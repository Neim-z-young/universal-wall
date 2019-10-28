package com.freeLearn.wall.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Header jwt头部对象
 * {
 *     "alg":“HS512"
 *     "typ":"JWT"
 * }
 * Payload  jwt负载对象
 * {
 *     "aud": username(唯一且不为空)
 *     "created"
 *     "exp":
 * }
 * Signature  jwt签名
 * {
 *
 * }
 *
 * Create by oyoungy on 2019/10/25
 */
@Component
@PropertySource("classpath:application.Properties")
public class JwtUtil {
    private static final String CLAIM_USERNAME_KEY = "aud";
    private static final String CLAIM_CREATED_KEY = "created";

    @Value("${jwt.secret}")  //未进行base64编码
    private String secret;

    @Value("${jwt.expiration")
    private Long expiration;

    /**
     * 生成token
     * 每次执行都会设置过期时间和CLAIM_CREATED_KEY的时间
     * @param claims
     * @return
     */
    private String generateToken(Map<String, Object> claims){
        claims.put(CLAIM_CREATED_KEY, new Date());
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 生成过期时间
     * @return
     */
    private Date generateExpirationDate(){
        return new Date(System.currentTimeMillis() + expiration*1000);
    }

    /**
     * 从token中获取负载Claims
     * @param token
     * @return
     */
    private Claims getClaimsFromToken(String token){
        Claims claims = null;
        try{
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
           System.out.println("token 错误 " +e.getMessage());
        }
        return claims;
    }

    /**
     * 从token中获取用户名
     * @param token
     * @return
     */
    public String getUsernameFromToken(String token){
        String username;
        Claims claims = getClaimsFromToken(token);
        try{
            username = claims.getAudience();
        }catch (Exception e){
            username = null;
        }
        return username;
    }

    /**
     * 从token中获取过期时间
     * @param token
     * @return
     */
    public Date getExpiredDateFromToken(String token){
        Date exp;
        Claims claims = getClaimsFromToken(token);
        try {
            exp = claims.getExpiration();
        }catch (Exception e){
            exp = null;
        }
        return exp;
    }

    /**
     * 判断token是否过期
     * @param token
     * @return
     */
    public boolean isTokenExpired(String token){
        Date exp = getExpiredDateFromToken(token);
        assert exp!=null; //断言token格式是正确的
        return !exp.before(new Date());
    }

    /**
     * 验证token是否有效
     * @param token
     * @param userDetails
     * @return
     */
    public boolean validateToken(String token, UserDetails userDetails){
        String username = getUsernameFromToken(token);
        return username!=null && username.equals(userDetails.getUsername()) && isTokenExpired(token);
    }

    /**
     * 根据用户信息生成token
     * @param userDetails
     * @return
     */
    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_USERNAME_KEY, userDetails.getUsername());
        return generateToken(claims);
    }

    /**
     * 判断能否刷新token
     * @param token
     * @return
     */
    public boolean canRefreshToken(String token){
        return isTokenExpired(token);
    }

    /**
     * 刷新token
     * @param token
     * @return
     */
    public String refreshToken(String token){
        Claims claims = getClaimsFromToken(token);
        return generateToken(claims);
    }
}

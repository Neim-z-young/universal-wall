package com.freeLearn.wall.service.impl;

import com.freeLearn.wall.common.CommonResult;
import com.freeLearn.wall.component.WallUserDetailsService;
import com.freeLearn.wall.domain.WallUserDetails;
import com.freeLearn.wall.dto.WallUserParam;
import com.freeLearn.wall.mapper.WallUserLoginLogMapper;
import com.freeLearn.wall.mapper.WallUserMapper;
import com.freeLearn.wall.model.WallUser;
import com.freeLearn.wall.model.WallUserExample;
import com.freeLearn.wall.model.WallUserLoginLog;
import com.freeLearn.wall.service.WallUserService;
import com.freeLearn.wall.util.DateUtil;
import com.freeLearn.wall.util.IPAddressUtil;
import com.freeLearn.wall.util.JwtUtil;
import com.freeLearn.wall.util.PasswordUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * 用户服务实现类
 * Create by oyoungy on 2019/10/26
 */
@Service
public class WallUserServiceImpl implements WallUserService {
    protected static final Logger LOGGER = LogManager.getLogger();

    @Value("${jwt.userRole}")
    private String ROLE_USER;

    @Autowired
    private WallUserMapper wallUserMapper;

    @Autowired
    private WallUserLoginLogMapper wallUserLoginLogMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DateUtil dateUtil;

    @Autowired
    private IPAddressUtil ipAddressUtil;

    //TODO 绑定UserDetailService
    @Autowired
    private WallUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordUtil passwordUtil;

    @Override
    public WallUser getByUsername(String username) {
        WallUserExample example = new WallUserExample();
        example.createCriteria().andUsernameEqualTo(username);
        List<WallUser> userList = wallUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){  //判断null和size为0
            return userList.get(0);
        }
        return null;
    }

    @Override
    public WallUser getByUserId(Integer userId) {
        return wallUserMapper.selectByPrimaryKey(userId);
    }

    @Override
    public WallUser getByOpenId(String openId) {
        WallUserExample example = new WallUserExample();
        example.createCriteria().andOpenIdEqualTo(openId);
        List<WallUser> userList = wallUserMapper.selectByExample(example);
        if(!CollectionUtils.isEmpty(userList)){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public CommonResult register(String username, String password) {
        //查询用户是否存在
        WallUser user = getByUsername(username);
        if(user!=null){
            return CommonResult.failed("用户名已存在");
        }
        WallUser newUser = new WallUser();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));
        newUser.setSignupTime(dateUtil.getEpochFromDate(new Date()));
        newUser.setStatus(true);
        newUser.setGender(0);
        newUser.setPoints(0);
        newUser.setGrowth(0);

        wallUserMapper.insert(newUser);
        newUser.setPassword(null);
        return CommonResult.success(null, "注册成功");
    }

    @Override
    public CommonResult register(WallUserParam wallUserParam) {
        //查询用户是否存在
        WallUser user = getByUsername(wallUserParam.getUsername());
        if(user!=null){
            return CommonResult.failed("用户名已存在");
        }
        WallUser wallUser = new WallUser();
        BeanUtils.copyProperties(wallUserParam, wallUser);
        String encodedPass = passwordEncoder.encode(wallUser.getPassword());
        wallUser.setPassword(encodedPass);
        if(wallUser.getGender()==null){
            wallUser.setGender(0);
        }
        wallUser.setSignupTime(dateUtil.getEpochFromDate(new Date()));
        wallUser.setStatus(true);
        wallUser.setPoints(0);
        wallUser.setGrowth(0);

        wallUserMapper.insert(wallUser);
        wallUser.setPassword(null);
        return CommonResult.success(null, "注册成功");
    }

    @Override
    public WallUser registerWeChat(String openId, String username) {
        WallUser newUser = getByOpenId(openId);
        if(newUser!=null){
            LOGGER.warn("Incorrect user register service calling");
            return null;
        }
        newUser = new WallUser();
        newUser.setOpenId(openId);
        newUser.setSignupTime(dateUtil.getEpochFromDate(new Date()));
        newUser.setStatus(true);
        newUser.setGender(0);
        newUser.setPoints(0);
        newUser.setGrowth(0);
        newUser.setUsername("wechat"+openId);
        newUser.setPassword(passwordEncoder.encode(passwordUtil.generateRandomPassword(15)));
        if(username!=null){
           newUser.setUsername(username);
        }
        wallUserMapper.insert(newUser);
        newUser.setPassword(null);
        return newUser;
    }

    @Override
    public CommonResult updatePassword(String username, String oldPassword, String newPassword) {
        WallUser user = getByUsername(username);
        if(user==null){
            return CommonResult.failed("用户不存在");
        }
        if (!user.getPassword().equals(passwordEncoder.encode(oldPassword))) {
            return CommonResult.failed("原密码错误");
        }
        user.setPassword(newPassword);
        wallUserMapper.updateByPrimaryKeySelective(user);
        return CommonResult.success(null, "密码修改成功");
    }

    @Override
    public WallUser getCurrentUser() {
        Authentication authentication = SecurityContextHolder
                .getContext()
                .getAuthentication();
//        System.out.println(authentication);
//        System.out.println(authentication.getPrincipal());
        if(authentication!=null && authentication.getPrincipal()!=null){
            UserDetails userDetails = (UserDetails)authentication.getPrincipal();
            if(userDetails instanceof WallUserDetails){
                return ((WallUserDetails) userDetails).getUser();
            }
            LOGGER.warn("Incorrect user Service calling");
        }
        LOGGER.debug("Do not logged in");
        return null;
    }

    @Override
    public CommonResult updateNickName(Integer userId, String newNickName) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setNickName(newNickName);
        wallUserMapper.updateByPrimaryKeySelective(user);
        return CommonResult.success(null, "昵称修改成功");
    }


    @Override
    public void updateGrowth(Integer userId, Integer growth) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setGrowth(growth);
        wallUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public void updatePoints(Integer userId, Integer newPoints) {
        WallUser user = new WallUser();
        user.setId(userId);
        user.setPoints(newPoints);
        wallUserMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if(!(userDetails instanceof WallUserDetails)){
                throw new AuthenticationServiceException("认证服务异常");
            }
            if(!passwordEncoder.matches(password, userDetails.getPassword())){
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtUtil.generateToken(userDetails, ROLE_USER);
            insertLoginLog(((WallUserDetails)userDetails).getUser().getId());
        } catch (BadCredentialsException | UsernameNotFoundException e){
            LOGGER.debug(e.getMessage());
        } catch (AuthenticationException e){
            //登录异常
            LOGGER.error(e.getMessage(), e);
        }
        return token;
    }

    @Override
    public String loginWeChat(String openId) {
        String token = null;
        WallUser user = getByOpenId(openId);
        if(user==null){
            user = registerWeChat(openId, null);
        }
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUsername());
            if(!(userDetails instanceof WallUserDetails)){
                throw new AuthenticationServiceException("认证服务异常");
            }
            UsernamePasswordAuthenticationToken authentication =
                    new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtUtil.generateToken(userDetails, ROLE_USER);
            insertLoginLog(((WallUserDetails)userDetails).getUser().getId());
        }catch (AuthenticationException e){
            //登录异常
            LOGGER.error(e.getMessage(), e);
        }
        return token;
    }

    @Override
    public int insertLoginLog(Integer userId) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String ipAddress =  request.getRemoteAddr();

        WallUserLoginLog wallUserLoginLog = new WallUserLoginLog();
        wallUserLoginLog.setUserId(userId);
        wallUserLoginLog.setCreateTime(dateUtil.getEpochFromDate(new Date()));
        wallUserLoginLog.setIpAddress(ipAddressUtil.ipString2Long(ipAddress));
        LOGGER.debug("User from ip: "+ipAddress+" logged in");
        return wallUserLoginLogMapper.insert(wallUserLoginLog);
    }
}

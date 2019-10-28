package com.freeLearn.wall.util;


import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class WeChatUtil {

    class ResObject{
        private String openid;
        private String sessionKey;
        private Integer errcode;
        private String errmsg;
    }
    @Value("${weChat.appId")
    private String WECHAT_APPID;
    @Value("${weChat.secret}")
    private String WECHAT_SECRET;

    String generateOpenId(String code){
        String openId = null;
        String url =  "https://api.weixin.qq.com/sns/jscode2session?appid=" + WECHAT_APPID + "&secret="
                + WECHAT_SECRET + "&js_code=" + code + "&grant_type=authorization_code";
        String response = httpRequest(url, "GET", null);
        //TODO write log
        System.out.println(response);
        JSONObject jsonObject = JSONUtil.parseObj(response);
        openId = jsonObject.get("openid").toString();
        return openId;
    }

    //refer to https://www.jianshu.com/p/ef1974f34601
    public String httpRequest(String requestUrl,String requestMethod,String output){
        try{
            URL url = new URL(requestUrl);
            //暂时使用http协议
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setDoInput(true);
            connection.setUseCaches(false);
            if(null != output){
                OutputStream outputStream = connection.getOutputStream();
                outputStream.write(output.getBytes("utf-8"));
                outputStream.close();
            }
            // 从输入流读取返回内容
            InputStream inputStream = connection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = null;
            StringBuffer buffer = new StringBuffer();
            while ((str = bufferedReader.readLine()) != null){
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            inputStream = null;
            connection.disconnect();
            return buffer.toString();
        }catch(Exception e){
            e.printStackTrace();
        }
        return "";
    }
}

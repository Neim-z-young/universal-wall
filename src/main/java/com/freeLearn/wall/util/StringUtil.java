package com.freeLearn.wall.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
    /**
     * 剪切origin字符串的前len长的字串。
     * 原字符串长度小于len则返回原字符串
     * @param origin
     * @param len
     * @return
     */
    public String cutStringHead(String origin, int len){
        String newStr = origin;
        if(newStr.length()>len){
            newStr = newStr.substring(0, len);
        }
        return newStr;
    }
}

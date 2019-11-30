package com.freeLearn.wall.util;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

@Component
public class ValidatorUtil {

    /**
     * 校验错误时生成的错误信息类
     */
    @Getter
    @Setter
    public static class ErrorInfo {
        private String field;
        private String info;
        private String type;
    }

    /**
     * 转换为string
     *
     * @param bindingResult
     * @return
     */
    public String getJsonString(BindingResult bindingResult) {
        if (bindingResult.getAllErrors().size() == 0) {
            return null;
        }
        List<ErrorInfo> errorInfoList = new ArrayList<ErrorInfo>();
        for (FieldError error : bindingResult.getFieldErrors()) {
            ErrorInfo errorInfo = new ErrorInfo();
            errorInfo.setField(error.getField());
            errorInfo.setInfo(error.getDefaultMessage());
            errorInfo.setType(error.getCode());
            errorInfoList.add(errorInfo);
        }
        String myInfo = JSONUtil.toJsonStr(errorInfoList);
        return myInfo;
    }
}
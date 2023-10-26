package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class WarningMessage<T> extends ResponseMessage {

    public WarningMessage(T data) {
        jsonObject.put("code", 301);
        jsonObject.put("message", "OK");
        jsonObject.put("data", data);
    }

    public WarningMessage(String message, T data) {
        jsonObject.put("code", 301);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
    }

    public WarningMessage(Integer code, T data) {
        jsonObject.put("code", 301);
        jsonObject.put("message", "OK");
        jsonObject.put("data", data);
    }

    public WarningMessage(Integer code, String message, T data) {
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
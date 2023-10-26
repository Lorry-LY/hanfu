package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class SuccessMessage<T> extends ResponseMessage {

    public SuccessMessage(T data) {
        jsonObject.put("code", 201);
        jsonObject.put("message", "OK");
        jsonObject.put("data", data);
    }

    public SuccessMessage(String message, T data) {
        jsonObject.put("code", 201);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
    }

    public SuccessMessage(Integer code, T data) {
        jsonObject.put("code", code);
        jsonObject.put("message", "OK");
        jsonObject.put("data", data);
    }

    public SuccessMessage(Integer code, String message, T data) {
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", data);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}


package com.zrh.hanfu.utils.message;


import com.alibaba.fastjson2.JSONObject;

public class ErrorMessage extends ResponseMessage {

    public ErrorMessage(String message) {
        jsonObject.put("code", 401);
        jsonObject.put("message", message);
        jsonObject.put("data", null);
    }

    public ErrorMessage(Integer code) {
        jsonObject.put("code", code);
        jsonObject.put("message", "a unknown error from client.");
        jsonObject.put("data", null);
    }

    public ErrorMessage(Integer code, String message) {
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", null);
    }

    @Override
    public JSONObject getMessage() {
        return jsonObject;
    }
}

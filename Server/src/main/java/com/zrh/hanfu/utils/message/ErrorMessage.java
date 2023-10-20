package com.zrh.hanfu.utils.message;


import com.alibaba.fastjson2.JSONObject;

public class ErrorMessage extends ResponseMessage {

    public ErrorMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    @Override
    public JSONObject getMessage() {
        return jsonObject;
    }
}

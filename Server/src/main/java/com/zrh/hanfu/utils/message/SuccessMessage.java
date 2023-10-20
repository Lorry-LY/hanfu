package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class SuccessMessage<T> extends ResponseMessage {

    public SuccessMessage(T data) {
        jsonObject.put("code", 200);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", data);
    }

    public SuccessMessage(String message) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", null);
    }

    public SuccessMessage(String message, T data) {
        jsonObject.put("code", 200);
        jsonObject.put("message", message);
        jsonObject.put("success", true);
        jsonObject.put("type", "success");
        jsonObject.put("data", data);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}


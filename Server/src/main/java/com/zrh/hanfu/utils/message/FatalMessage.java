package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class FatalMessage extends ResponseMessage{

    public FatalMessage(String message) {
        jsonObject.put("code", 501);
        jsonObject.put("message", message);
        jsonObject.put("data", null);
    }

    public FatalMessage(Integer code) {
        jsonObject.put("code", code);
        jsonObject.put("message", "a unknown error from server.");
        jsonObject.put("data", null);
    }

    public FatalMessage(Integer code, String message) {
        jsonObject.put("code", code);
        jsonObject.put("message", message);
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}

package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class WarningMessage extends ResponseMessage {

    public WarningMessage(String message) {
        jsonObject.put("code", 249);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "warning");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
package com.zrh.petserver.utils.message;

import org.json.JSONObject;

public class WarningMessage extends ResponseMessage {

    public WarningMessage(String message) {
        jsonObject.put("code", 249);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "warning");
        jsonObject.put("data", JSONObject.NULL);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}
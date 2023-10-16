package com.zrh.petserver.utils.message;


import org.json.JSONObject;

public class ErrorMessage extends ResponseMessage {

    public ErrorMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", JSONObject.NULL);
    }

    @Override
    public JSONObject getMessage() {
        return jsonObject;
    }
}

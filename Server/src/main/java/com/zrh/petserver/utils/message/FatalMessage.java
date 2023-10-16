package com.zrh.petserver.utils.message;

import org.json.JSONObject;

public class FatalMessage extends ResponseMessage{

    public FatalMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", JSONObject.NULL);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}

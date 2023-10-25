package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;

public class NoTokenMessage extends ResponseMessage{

    public NoTokenMessage() {
        jsonObject.put("code", 420);
        jsonObject.put("message", "no token");
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    @Override
    public JSONObject getMessage() {
        return jsonObject;
    }
}

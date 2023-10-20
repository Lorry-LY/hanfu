package com.zrh.hanfu.utils.message;

import com.alibaba.fastjson2.JSONObject;
import org.apache.el.stream.Optional;

public class FatalMessage extends ResponseMessage{

    public FatalMessage(String message) {
        jsonObject.put("code", 500);
        jsonObject.put("message", message);
        jsonObject.put("success", false);
        jsonObject.put("type", "error");
        jsonObject.put("data", null);
    }

    public JSONObject getMessage() {
        return jsonObject;
    }
}

package com.zrh.hanfu.utils.exception;

import com.alibaba.fastjson2.JSONObject;

public class AddTokenException extends RuntimeException {
    private final JSONObject message;

    public AddTokenException(JSONObject message) {
        super(message.toString());
        this.message = message;
    }

    public String getMessage() {
        return message.toString();
    }
}

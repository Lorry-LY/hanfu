package com.zrh.petserver.utils.message;


import org.json.JSONObject;

public abstract class ResponseMessage {

    protected JSONObject jsonObject = new JSONObject();

    abstract public JSONObject getMessage();

}

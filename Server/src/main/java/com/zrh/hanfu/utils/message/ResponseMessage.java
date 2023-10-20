package com.zrh.hanfu.utils.message;


import com.alibaba.fastjson2.JSONObject;

public abstract class ResponseMessage {

    protected JSONObject jsonObject = new JSONObject();

    abstract public JSONObject getMessage();

}

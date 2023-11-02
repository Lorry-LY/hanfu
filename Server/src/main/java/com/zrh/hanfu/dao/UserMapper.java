package com.zrh.hanfu.dao;

import com.alibaba.fastjson2.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    public JSONObject findUserByUserID(String userID){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("password","123456");

        return jsonObject;
    }

    public String findUsernameByUserID(String userID){
        return "";
    }

    public String findPasswordByUserID(String userID){
        return "123456";
    }

}

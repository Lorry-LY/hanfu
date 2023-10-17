package com.zrh.petserver.dao;

import org.json.JSONObject;
import org.springframework.stereotype.Repository;

@Repository
public class UserMapper {

    public JSONObject findUserByUserID(String userID){
        JSONObject jsonObject = new JSONObject();


        return jsonObject;
    }

    public String findUsernameByUserID(String userID){
        return "";
    }

    public String findPasswordByUserID(String userID){
        return "";
    }

}

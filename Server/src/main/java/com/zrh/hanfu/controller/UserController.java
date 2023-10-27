package com.zrh.hanfu.controller;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.zrh.hanfu.config.Interceptor.JWTUtils;
import com.zrh.hanfu.utils.annotation.AddToken;
import com.zrh.hanfu.utils.annotation.DeleteToken;
import com.zrh.hanfu.utils.annotation.PassToken;
import com.zrh.hanfu.utils.annotation.UserLoginToken;
import com.zrh.hanfu.utils.message.SuccessMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {

    @AddToken
    @PassToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(
            @RequestBody JSONObject body
    ) {
        String userID = body.getString("userID");
        String password = body.getString("password");



        String token = JWTUtils.createToken(userID, password);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token",token);
        return new SuccessMessage<>(jsonObject).getMessage();
    }

    @UserLoginToken
    @RequestMapping(value = "/info", method = RequestMethod.POST)
    public JSONObject info(
            @RequestBody JSONObject body
    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(body).getMessage();
    }

    @PassToken
    @RequestMapping(value = "/notoken", method = RequestMethod.GET)
    public JSONObject notoken(
    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(new JSONObject()).getMessage();
    }

    @UserLoginToken
    @RequestMapping(value = "/token", method = RequestMethod.GET)
    public JSONObject token(

    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(new JSONObject()).getMessage();
    }

    @PassToken
    @DeleteToken
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public JSONObject logout(
            @RequestBody JSONObject body
    ) {

        String userID = body.getString("userID");


        JSONObject jsonObject = new JSONObject();
        jsonObject.put("token","");
        return new SuccessMessage<>(jsonObject).getMessage();
    }

}

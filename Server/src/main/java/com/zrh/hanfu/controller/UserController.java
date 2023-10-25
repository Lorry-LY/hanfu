package com.zrh.hanfu.controller;

import com.alibaba.fastjson2.JSONObject;
import com.zrh.hanfu.utils.annotation.AddToken;
import com.zrh.hanfu.utils.annotation.DeleteToken;
import com.zrh.hanfu.utils.annotation.PassToken;
import com.zrh.hanfu.utils.annotation.UserLoginToken;
import com.zrh.hanfu.utils.message.ResponseMessage;
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
        //String ID = body.getString("ID");
        return new SuccessMessage<>(body).getMessage();
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
    @DeleteToken
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public JSONObject logout(
            @RequestBody JSONObject body
    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(body).getMessage();
    }

}

package com.zrh.hanfu.controller;

import com.alibaba.fastjson2.JSONObject;
import com.zrh.hanfu.utils.annotation.PassToken;
import com.zrh.hanfu.utils.message.ResponseMessage;
import com.zrh.hanfu.utils.message.SuccessMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseMessage login(
            @RequestBody JSONObject body
    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(body);
    }

    @PassToken
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public ResponseMessage logout(
            @RequestBody JSONObject body
    ) {
        //String ID = body.getString("ID");
        return new SuccessMessage<>(body);
    }

}

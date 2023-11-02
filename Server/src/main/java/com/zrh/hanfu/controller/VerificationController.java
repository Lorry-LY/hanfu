package com.zrh.hanfu.controller;

import com.alibaba.fastjson2.JSONObject;
import com.zrh.hanfu.utils.annotation.AddToken;
import com.zrh.hanfu.utils.annotation.PassToken;
import com.zrh.hanfu.utils.annotation.UserLoginToken;
import com.zrh.hanfu.utils.message.SuccessMessage;
import com.zrh.hanfu.utils.sms.VerificationCode;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/verify")
@RestController
public class VerificationController {

    @UserLoginToken
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public JSONObject login(
            @RequestBody JSONObject body
    ) {
        String phoneNumber = body.getString("phoneNumber");
        String stateCode = body.getString("state");
        JSONObject jsonObject = new JSONObject();
        if(VerificationCode.hasCode(phoneNumber,stateCode)){
            String code = VerificationCode.getCode(phoneNumber, stateCode);
            jsonObject.put("code",code);
            jsonObject.put("state","keep");
        }else{
            String code = VerificationCode.requestVerificationCode(phoneNumber, stateCode);
            jsonObject.put("code",code);
            jsonObject.put("state","create");
        }
        return new SuccessMessage<>(jsonObject).getMessage();
    }

}

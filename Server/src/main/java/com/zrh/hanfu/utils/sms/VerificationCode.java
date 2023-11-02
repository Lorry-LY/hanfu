package com.zrh.hanfu.utils.sms;

import ch.qos.logback.core.joran.sanity.Pair;

import javax.xml.bind.PropertyException;
import java.awt.*;
import java.util.*;

public class VerificationCode {

    private static Map<String, Map<String,String>> tables = new HashMap<>();

    //验证码过期时间：10s
    private static final long REMOVE_CODE_TIME = 1000 * 10;

    private static final long CODE_LEN = 1000000;

    public static String requestVerificationCode(String phoneNumber, String stateCode){
            String state = VerificationState.getSate(stateCode);
            if (tables.containsKey(phoneNumber)) {
                Map<String, String> table = tables.get(phoneNumber);
                if (table.containsKey(state)){
                    return table.get(state);
                }else {
                    String code = generateCode(phoneNumber,state);
                    table.put(state,code);
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            removeCode(phoneNumber,stateCode);
                        }
                    }, REMOVE_CODE_TIME);
                    return code;
                }
            } else {
                tables.put(phoneNumber, new HashMap<>());
                String code = generateCode(phoneNumber,state);
                tables.get(phoneNumber).put(state,code);
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        removeCode(phoneNumber,stateCode);
                    }
                }, REMOVE_CODE_TIME);
                return code;
            }
    }

    private static String generateCode(String phoneNumber,String state){
        long a = Long.parseLong(phoneNumber);
        long b = Long.parseLong(state);
        long factor = a / b;
        long random = new Random().nextLong();
        if (random<0) random *= -1;
        long result = (random + factor) % CODE_LEN;
        return String.valueOf(result);
    }

    public static void removeCode(String phoneNumber,String stateCode){
        String state = VerificationState.getSate(stateCode);
        if (state==null)return;
        if (tables.containsKey(phoneNumber)) {
            Map<String, String> table = tables.get(phoneNumber);
            if (table.containsKey(state)){
                table.remove(state);
            }
        }
    }

    public static String getCode(String phoneNumber,String stateCode){
        String state = VerificationState.getSate(stateCode);
        if (state==null) return null;
        if (tables.containsKey(phoneNumber)) {
            Map<String, String> table = tables.get(phoneNumber);
            if (table.containsKey(state)){
                return table.get(state);
            }
        }
        return null;
    }

    public static Boolean hasCode(String phoneNumber,String stateCode){
        String state = VerificationState.getSate(stateCode);
        if (state==null) return false;
        if (tables.containsKey(phoneNumber)) {
            Map<String, String> table = tables.get(phoneNumber);
            return table.containsKey(state);
        }
        return false;
    }

    public static void sendVerificationCode(String phoneNumber, String verificationCode) {

    }

}

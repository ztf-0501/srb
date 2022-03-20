package com.atguigu.srb.sms.service.impl;

import com.atguigu.srb.sms.service.SmsService;
import com.zhenzi.sms.ZhenziSmsClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@Slf4j
public class SmsServiceImpl implements SmsService {
    @Value(value = "${rckj.apiUrl}")
    private String APIURL;
    @Value(value = "${rckj.appId}")
    private String APPID;
    @Value(value = "${rckj.appSecret}")
    private String APPSECRET;

    @Override
    public void send(String mobile,Map<String,Object> params) {
        ZhenziSmsClient client = new ZhenziSmsClient(APIURL, APPID, APPSECRET);

        params.put("number", mobile); //手机号
        params.put("templateId", "7112"); //模板ID
        String[] templateParams = new String[2];
        templateParams[0] = params.get("code").toString(); //验证码
        templateParams[1] = "5分钟";
        params.put("templateParams", templateParams);
        try {
            String result = client.send(params);
            log.info("-------------"+result);
            //result.getBytes("0")：转码异常
            //System.out.println("result.getBytes()="+result.getBytes("0"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

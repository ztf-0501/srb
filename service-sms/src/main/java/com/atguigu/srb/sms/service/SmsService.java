package com.atguigu.srb.sms.service;

import java.util.Map;

public interface SmsService {

    void send(String mobile,Map<String,Object> params);
}

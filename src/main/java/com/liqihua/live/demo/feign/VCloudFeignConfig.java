package com.liqihua.live.demo.feign;

import cn.hutool.crypto.SecureUtil;
import com.liqihua.live.demo.feign.logger.InfoFeignLoggerFactory;
import feign.Logger;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.UUID;


public class VCloudFeignConfig implements RequestInterceptor {
    /**
     * 网易云信的应用appKey
     */
    @Value("${vcloud.appKey}")
    private String appKey;
    @Value("${vcloud.appSecret}")
    private String appSecret;


    /**
     * 每次请求header中必须带有以下参数
     * AppKey：开发者平台分配的AppKey
     * Nonce：随机数（随机数，最大长度128个字符）
     * CurTime：当前UTC时间戳，从1970年1月1日0点0分0秒开始到现在的秒数
     * CheckSum：服务器认证需要，SHA1(AppSecret+Nonce+CurTime)，16进制字符小写
     * @param template
     */
    @Override
    public void apply(RequestTemplate template) {
        String nonce = UUID.randomUUID().toString().replace("-","");
        String curTime = System.currentTimeMillis()/1000 + "";
        String checkSum = SecureUtil.sha1(appSecret + nonce + curTime);
        template.header("AppKey",appKey);
        template.header("Nonce",nonce);
        template.header("CurTime",curTime);
        template.header("CheckSum",checkSum);
    }


    /**
     * feign日志信息级别
     * @return
     */
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public InfoFeignLoggerFactory infoFeignLoggerFactory() {
        return new InfoFeignLoggerFactory();
    }

    /**
     * 设置feign超时时间
     * @return
     */
    @Bean
    public Request.Options options() {
        return new Request.Options(60000, 60000);
    }
}

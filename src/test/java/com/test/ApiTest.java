package com.test;

import com.alibaba.fastjson.JSON;
import com.liqihua.live.demo.Application;
import com.liqihua.live.demo.dto.AddressDTO;
import com.liqihua.live.demo.dto.ChannelListDTO;
import com.liqihua.live.demo.dto.CreateChannelDTO;
import com.liqihua.live.demo.feign.VCloudFeignApi;
import com.liqihua.live.demo.vo.AddressVO;
import com.liqihua.live.demo.vo.ChannelListVO;
import com.liqihua.live.demo.vo.CreateChannelVO;
import com.liqihua.live.demo.vo.VCloudVO;
import io.agora.media.RtcTokenBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = Application.class)
public class ApiTest {
    private static final Logger logger = LoggerFactory.getLogger(ApiTest.class);


    @Autowired
    private VCloudFeignApi vCloudFeignApi;

    @Test
    void createChannel() {
        CreateChannelDTO param = new CreateChannelDTO();
        param.setName("测试频道1");
        param.setType(0);
        VCloudVO<CreateChannelVO> vo = vCloudFeignApi.createChannel(param);
        logger.info(JSON.toJSONString(vo));
    }


    @Test
    void channelList() {
        VCloudVO<ChannelListVO> vo = vCloudFeignApi.channelList(new ChannelListDTO());
        logger.info(JSON.toJSONString(vo));
    }

    @Test
    void address() {
        AddressDTO param = new AddressDTO();
        param.setCid("26a85bc911914c80aa747a62cb2f44ea");
        VCloudVO<AddressVO> vo = vCloudFeignApi.address(param);
        logger.info(JSON.toJSONString(vo));
    }


    static String appId = "72cab20262db446d9e6f31b20cd4d495";
    static String appCertificate = "5069e1a8fb76434f827313bf180b6fdd";
    static String channelName = "channel1";
    static String userAccount = "2082341273";
    static int uid = 2082341273;
    static int expirationTimeInSeconds = 3600;


    @Test
    void makeToken() {
        RtcTokenBuilder token = new RtcTokenBuilder();
        int timestamp = (int)(System.currentTimeMillis() / 1000 + expirationTimeInSeconds);
        String result = token.buildTokenWithUserAccount(appId, appCertificate,
                channelName, userAccount, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        System.out.println("token：" + result);

        result = token.buildTokenWithUid(appId, appCertificate,
                channelName, uid, RtcTokenBuilder.Role.Role_Publisher, timestamp);
        System.out.println("token：" + result);
    }

}

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
        /**
         * {
         *   "ret": {
         *     "httpPullUrl": "http://flv0c8a7d4d.live.126.net/live/26a85bc911914c80aa747a62cb2f44ea.flv?netease=flv0c8a7d4d.live.126.net",
         *     "hlsPullUrl": "http://pullhls0c8a7d4d.live.126.net/live/26a85bc911914c80aa747a62cb2f44ea/playlist.m3u8",
         *     "rtmpPullUrl": "rtmp://v0c8a7d4d.live.126.net/live/26a85bc911914c80aa747a62cb2f44ea",
         *     "name": "测试频道2",
         *     "pushUrl": "rtmp://p0c8a7d4d.live.126.net/live/26a85bc911914c80aa747a62cb2f44ea?wsSecret=3bb35e5855ca84d1b2bb424b4b1645ef&wsTime=1578374315"
         *   },
         *   "requestId": "live77fbafd1-417f-4d8a-bf42-15b0b60cded8",
         *   "code": 200
         * }
         */
    }
}

package com.liqihua.live.demo.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.liqihua.live.demo.dto.CreateChannelDTO;
import com.liqihua.live.demo.feign.VCloudFeignApi;
import com.liqihua.live.demo.vo.CreateChannelVO;
import com.liqihua.live.demo.vo.VCloudVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private VCloudFeignApi vCloudFeignApi;


    @GetMapping("/test1")
    public Object test1() {
        logger.debug("123");
        return "test1";
    }

    @GetMapping("/createChannel")
    public Object createChannel(String name) {
        CreateChannelDTO param = new CreateChannelDTO();
        param.setName(name);
        param.setType(0);
        if(StrUtil.isNotBlank(name)) {
            VCloudVO<CreateChannelVO> vo = vCloudFeignApi.createChannel(param);
            String result = JSON.toJSONString(vo);
            logger.info(result);
            return result;
        }
        return "error";
    }


}

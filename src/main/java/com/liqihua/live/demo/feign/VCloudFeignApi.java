package com.liqihua.live.demo.feign;

import com.liqihua.live.demo.dto.AddressDTO;
import com.liqihua.live.demo.dto.ChannelListDTO;
import com.liqihua.live.demo.dto.CreateChannelDTO;
import com.liqihua.live.demo.vo.AddressVO;
import com.liqihua.live.demo.vo.ChannelListVO;
import com.liqihua.live.demo.vo.CreateChannelVO;
import com.liqihua.live.demo.vo.VCloudVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "VCloudFeignApi", url = "https://vcloud.163.com/app",configuration = VCloudFeignConfig.class)
public interface VCloudFeignApi {

    @PostMapping("/channel/create")
    VCloudVO<CreateChannelVO> createChannel(CreateChannelDTO param);

    @PostMapping("/channellist")
    VCloudVO<ChannelListVO> channelList(ChannelListDTO param);

    @PostMapping("/address")
    VCloudVO<AddressVO> address(AddressDTO param);

}

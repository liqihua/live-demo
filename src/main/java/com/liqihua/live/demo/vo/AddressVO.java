package com.liqihua.live.demo.vo;

import lombok.Data;

@Data
public class AddressVO {
    /**
     * 推流地址
     */
    private String pushUrl;
    /**
     * http拉流地址
     */
    private String httpPullUrl;
    /**
     * hls拉流地址
     */
    private String hlsPullUrl;
    /**
     * rtmp拉流地址
     */
    private String rtmpPullUrl;
}

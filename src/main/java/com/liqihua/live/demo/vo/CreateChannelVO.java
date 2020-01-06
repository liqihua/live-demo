package com.liqihua.live.demo.vo;

import lombok.Data;

@Data
public class CreateChannelVO {

    /**
     * 频道ID，32位字符串
     */
    private String cid;
    /**
     *
     * 创建频道的时间戳
     */
    private Long ctime;
    /**
     * 频道名称
     */
    private String name;
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

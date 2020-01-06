package com.liqihua.live.demo.vo;

import lombok.Data;

@Data
public class ChannelListItemVO {
    /**
     * 创建频道的时间戳
     */
    private Long ctime;
    /**
     * 频道ID，32位字符串
     */
    private String cid;
    /**
     * 频道名称
     */
    private String name;
    /**
     * 频道状态（0：空闲； 1：直播； 2：禁用； 3：直播录制）
     */
    private Integer status;
    /**
     * 频道类型 ( 0 : rtmp, 1 : hls, 2 : http)
     */
    private Integer type;
    /**
     * 用户ID，是用户在网易云视频与通信业务的标识，用于与其他用户的业务进行区分。通常，用户不需关注和使用。
     */
    private Long uid;
    /**
     *  1-开启录制； 0-关闭录制
     */
    private Integer needRecord;
    /**
     * 1-flv； 0-mp4
     */
    private Integer format;
    /**
     * 录制切片时长(分钟)，默认120分钟
     */
    private Integer duration;
    /**
     *  录制后文件名
     */
    private String filename;
}

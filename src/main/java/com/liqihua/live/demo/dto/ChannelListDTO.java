package com.liqihua.live.demo.dto;

import lombok.Data;

@Data
public class ChannelListDTO {
    /**
     * 单页记录数，默认值为10
     */
    private Integer records;
    /**
     * 要取第几页，默认值为1
     */
    private Integer pnum;
    /**
     * 排序的域，支持的排序域为：ctime（默认）
     */
    private String ofield;
    /**
     * 升序还是降序，1升序，0降序，默认为desc
     */
    private Integer sort;
    /**
     * 筛选频道状态，status取值：（0：空闲,1：直播，2：禁用，3：录制中）
     */
    private Integer status;
}

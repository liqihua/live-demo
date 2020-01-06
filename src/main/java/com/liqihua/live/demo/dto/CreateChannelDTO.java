package com.liqihua.live.demo.dto;

import lombok.Data;

@Data
public class CreateChannelDTO {
    /**
     * 频道名称（最大长度64个字符，只支持中文、字母、数字和下划线）
     * 必传
     */
    private String name;
    /**
     * 频道类型（0:rtmp）
     * 必传
     */
    private Integer type;
}

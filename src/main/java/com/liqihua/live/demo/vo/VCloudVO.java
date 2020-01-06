package com.liqihua.live.demo.vo;

import lombok.Data;

@Data
public class VCloudVO<T> {
    /**
     * 状态码
     */
    private Integer code;

    /**
     * 错误信息
     */
    private String msg;

    /**
     * 返回的结果集
     */
    private T ret;

    /**
     * 用户唯一请求标识字符串
     */
    private String requestId;
}

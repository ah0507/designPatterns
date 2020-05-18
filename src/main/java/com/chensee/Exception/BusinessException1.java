package com.chensee.Exception;

import lombok.Data;

@Data
public class BusinessException1 extends RuntimeException {

    /**
     * 结果码
     */
    private String code;

    private String param;

    public BusinessException1(String code) {
        this.code = code;
    }

    public BusinessException1(String code, String param) {
        this.code = code;
        this.param = param;
    }
}

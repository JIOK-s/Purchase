package com.jiok.purchase.domain.quotation;

public enum Funnel {
    MOBILE(1), WEB(2);

    private final Integer code;

    Funnel(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

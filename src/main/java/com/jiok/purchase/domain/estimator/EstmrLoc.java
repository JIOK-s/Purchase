package com.jiok.purchase.domain.estimator;

public enum EstmrLoc {
    SEOUL(1), GYEONGKI(2);

    private final Integer code;

    EstmrLoc(Integer code) {
        this.code = code;
    }

    public Integer getCode() { return code; }
}

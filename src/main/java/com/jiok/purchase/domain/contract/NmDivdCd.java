package com.jiok.purchase.domain.contract;

public enum NmDivdCd {

    PERSONAL(10), // 개인
    PERSONAL_BUSINESS(20), // 개인사업자
    CORPORATION(30) //법인
    ;

    private final Integer code;

    NmDivdCd(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

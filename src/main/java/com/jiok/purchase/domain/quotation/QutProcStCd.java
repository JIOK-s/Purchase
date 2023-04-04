package com.jiok.purchase.domain.quotation;

public enum QutProcStCd {
    REQUEST(10),          // 견적요청
    PROCEEDING(20),       // 견적진행중
    RECEIVE(30),          // 견적수신
    COMPLETE(40),         // 견적수락
    CANCEL(90)            // 견적취소
    ;
    private final Integer code;

    QutProcStCd(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

package com.jiok.purchase.domain.visitEstimate;

public enum VisitEstmProcStCd {
    REQUEST(10),        // 평가요청
    PROCEEDING(20),     // 평가중
    COMPLETE(30)        // 평가완료
    ;

    private final Integer code;

    VisitEstmProcStCd(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

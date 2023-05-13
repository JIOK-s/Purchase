package com.jiok.purchase.domain.delivery;

public enum DlvProcStCd {

    DELIVERY_ORDER(10),     // 배송주문
    ORDER_CONFIRM(20),      // 주문확인
    SHIPPING(30),           // 배송중
    DELIVERY_COMPLETE(40),  // 배송완료
    DELIVERY_CANCEL(90)    // 배송취소
    ;

    private final Integer code;

    DlvProcStCd(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}

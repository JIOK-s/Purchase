package com.jiok.purchase.entity;

import lombok.*;

import javax.persistence.DiscriminatorValue;

@DiscriminatorValue("General")
@ToString
@Getter
@NoArgsConstructor
public class GeneralProduct extends UserProduct {

    @Builder
    public GeneralProduct(Long userProdNo, OriginProduct originProduct, Members members, Integer usedPeriod) {
        super(userProdNo, originProduct, members, usedPeriod);
    }



}

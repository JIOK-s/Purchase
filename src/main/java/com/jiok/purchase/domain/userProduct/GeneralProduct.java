package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.marketPrice.MarketPrice;
import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("General")
@ToString
@Getter
@NoArgsConstructor
public class GeneralProduct extends UserProduct {

    @Builder
    public GeneralProduct(Long userProdNo, OriginProduct originProduct, Members members, Integer usedPeriod, MarketPrice marketPrice) {
        super(userProdNo, originProduct, members, usedPeriod, marketPrice);
    }
}

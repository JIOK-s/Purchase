package com.jiok.purchase.domain.userProduct;


import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Car")
@ToString
@Getter
@NoArgsConstructor
public class CarProduct extends UserProduct{

    private Integer mileage;

    private Boolean accidentTf;

    private Boolean repairTf;

    @Builder
    public CarProduct(Long userProdNo, OriginProduct originProduct, Members members, Integer usedPeriod, Integer mileage, Boolean accidentTf, Boolean repairTf) {
        super(userProdNo, originProduct, members, usedPeriod);
        this.mileage = mileage;
        this.accidentTf = accidentTf;
        this.repairTf = repairTf;
    }
}

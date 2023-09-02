package com.jiok.purchase.web.dto.request;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.userProduct.CarProduct;
import com.jiok.purchase.domain.userProduct.GeneralProduct;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RequestUserProductManagement {
    private Long userProdNo;
    private Integer usedPeriod;
    private boolean isCar;
    private Long mbrId;

    public static GeneralProduct toGeneralEntity(Long userProdNo, Integer usedPeriod, Long mbrId, String mbrPhone) {
        return GeneralProduct.builder()
                .userProdNo(userProdNo)
                .usedPeriod(usedPeriod)
                .members(Members.builder().mbrId(mbrId).mbrPhone(mbrPhone).build())
                .build();
    };

    public CarProduct toCarEntity() {
        return CarProduct.builder()
                .userProdNo(userProdNo)
                .usedPeriod(usedPeriod)
                .members(Members.builder().mbrId(mbrId).build())
                .build();
    };

}

package com.jiok.purchase.web.dto.response;

import com.jiok.purchase.domain.userProduct.CarProduct;
import com.jiok.purchase.domain.userProduct.GeneralProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
public class ResponseGetUserProductManagement {
    private Long userProdNo;
    private Integer usedPeriod;
    private Long mbrId;

    @Builder
    public ResponseGetUserProductManagement(Long userProdNo, Integer usedPeriod, Long mbrId) {
        this.userProdNo = userProdNo;
        this.usedPeriod = usedPeriod;
        this.mbrId = mbrId;
    }

    public List<ResponseGetUserProductManagement> toGeneralDto(List<GeneralProduct> generalProductList) {
        return generalProductList.stream()
                .map(item -> ResponseGetUserProductManagement.builder()
                        .userProdNo(item.getUserProdNo())
                        .usedPeriod(item.getUsedPeriod())
                        .mbrId(item.getMembers().getMbrId())
                        .build())
                .collect(Collectors.toList());
    };

    public ResponseGetUserProductManagement toCarDto(CarProduct carProduct) {
        return ResponseGetUserProductManagement.builder()
                .userProdNo(carProduct.getUserProdNo())
                .usedPeriod(carProduct.getUsedPeriod())
                .mbrId(carProduct.getMembers().getMbrId())
                .build();
    };

}

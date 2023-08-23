package com.jiok.purchase.web.controller;

import com.jiok.purchase.domain.userProduct.GeneralProduct;
import com.jiok.purchase.service.UserProductService;
import com.jiok.purchase.web.dto.request.RequestGetUserProductManagement;
import com.jiok.purchase.web.dto.response.ResponseGetUserProductManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/v1/userProduct")
@RequiredArgsConstructor
public class UserProductManagement {

    private final UserProductService userProductService;

    @GetMapping("/getUserProductManagement")
    private ResponseGetUserProductManagement getUserProductManagement(
            @RequestBody RequestGetUserProductManagement requestGetUserProductManagement
    ) {
        // entity로 바꾼다
        GeneralProduct generalProduct = requestGetUserProductManagement.toGeneralEntity();

        // service 호출
        List<GeneralProduct> generalProductList = userProductService.findUserProductManagement(generalProduct);

        // dto로 바꾼다.
        ResponseGetUserProductManagement responseGetUserProductManagement = new ResponseGetUserProductManagement();
        responseGetUserProductManagement.toGeneralDto(generalProductList);

        // return
        return responseGetUserProductManagement;

    }

}

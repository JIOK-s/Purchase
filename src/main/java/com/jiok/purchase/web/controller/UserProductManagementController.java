package com.jiok.purchase.web.controller;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.userProduct.GeneralProduct;
import com.jiok.purchase.service.UserProductService;
import com.jiok.purchase.web.dto.response.ResponseGetUserProductManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/userProduct")
@RequiredArgsConstructor
public class UserProductManagementController {
    private final UserProductService userProductService;

    @GetMapping("/getUserProductManagement")
    public ResponseEntity<List<ResponseGetUserProductManagement>> getUserProductManagement(
            @RequestParam(name = "userProdNo", required = false) Long userProdNo,
            @RequestParam(name = "usedPeriod", required = false) Integer usedPeriod,
            @RequestParam(name = "mbrId", required = false) Long mbrId
    ) {
        // TODO:DTO로 넣기.
        // entity로 바꾼다
        GeneralProduct generalProduct = GeneralProduct.builder()
                .userProdNo(userProdNo)
                .usedPeriod(usedPeriod)
                .members(Members.builder().mbrId(mbrId).build())
                .build();

        // service 호출
        List<GeneralProduct> generalProductList = userProductService.findUserProductManagement(generalProduct);

        // dto로 바꾼다.
        ResponseGetUserProductManagement responseGetUserProductManagement = new ResponseGetUserProductManagement();
        List<ResponseGetUserProductManagement> responseGetUserProductManagementList = responseGetUserProductManagement.toGeneralDto(generalProductList);

        // return
        return ResponseEntity.ok().body(responseGetUserProductManagementList);

    }

}

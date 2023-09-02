package com.jiok.purchase.web.controller;

import com.jiok.purchase.domain.userProduct.GeneralProduct;
import com.jiok.purchase.service.UserProductService;
import com.jiok.purchase.web.dto.request.RequestUserProductManagement;
import com.jiok.purchase.web.dto.response.ResponseUserProductManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/userProduct")
@RequiredArgsConstructor
public class UserProductManagementController {
    private final UserProductService userProductService;

    /**
     * 구매 관리 조회
     * @param paramUserProdNo: 유저상품번호
     * @param paramUsedPeriod
     * @param paramMbrId
     * @return
     */
    @GetMapping("/management")
    public ResponseEntity<List<ResponseUserProductManagement>> getUserProductManagement(
            @RequestParam(name = "userProdNo", required = false) Long paramUserProdNo,
            @RequestParam(name = "usedPeriod", required = false) Integer paramUsedPeriod,
            @RequestParam(name = "mbrId", required = false) Long paramMbrId,
            @RequestParam(name = "mbrPhone", required = false) String paramMbrPhone
    ) {
        // entity로 바꾼다
        GeneralProduct generalProduct =
                RequestUserProductManagement.toGeneralEntity(paramUserProdNo, paramUsedPeriod, paramMbrId, paramMbrPhone);

        // service 호출
        List<GeneralProduct> generalProductList =
                userProductService.findUserProductManagement(generalProduct);

        // dto로 바꾼다.
        List<ResponseUserProductManagement> responseUserProductManagementList =
                ResponseUserProductManagement.toGeneralDto(generalProductList);

        // return
        return ResponseEntity.ok().body(responseUserProductManagementList);
    }

//
//    @PatchMapping("/management/userPeriod")
//    public ResponseEntity<List<ResponseUserProductManagement>> updateUsedPeriod (
//
//    ) {
//        return null;
//    }
}

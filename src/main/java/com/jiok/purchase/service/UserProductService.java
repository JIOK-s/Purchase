package com.jiok.purchase.service;

import com.jiok.purchase.domain.userProduct.GeneralProduct;
import com.jiok.purchase.domain.userProduct.GeneralProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserProductService {

    private final GeneralProductRepository generalProductRepository;

    public List<GeneralProduct> findUserProductManagement(GeneralProduct paramGeneralProduct) {
        return generalProductRepository.findUserProductManagement(paramGeneralProduct);
    }

}

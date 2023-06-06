package com.jiok.purchase.service;

import com.jiok.purchase.domain.originProduct.OriginProduct;
import com.jiok.purchase.domain.originProduct.OriginProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OriginProductService {
    @Autowired
    OriginProductRepository originProductRepository;

    public OriginProduct save(OriginProduct originProduct) {
        return originProductRepository.save(originProduct);
    }


}

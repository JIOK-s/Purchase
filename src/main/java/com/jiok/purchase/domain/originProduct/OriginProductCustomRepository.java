package com.jiok.purchase.domain.originProduct;

public interface OriginProductCustomRepository {

    public OriginProduct findByProdUniqNo(Long prodUniqNo);

}

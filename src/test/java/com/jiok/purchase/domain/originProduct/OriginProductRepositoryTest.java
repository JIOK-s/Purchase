package com.jiok.purchase.domain.originProduct;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class OriginProductRepositoryTest {

    @Autowired
    OriginProductRepository originProductRepository;

    @Test
    public void originProductRepositorySaveTest() {
        //given
        OriginProduct originProductA = OriginProduct.builder()
                .prodUniqNo(123123L)
                .orgPrice(123123)
                .build();

        //when
        OriginProduct savedOriginProduct = originProductRepository.save(originProductA);

        //then
        Assertions.assertThat(savedOriginProduct).isEqualTo(originProductA);
    }

    @Test
    public void originProductRepositoryFindByProdUniqNoTest() {
        //given
        OriginProduct originProductA = OriginProduct.builder()
                .prodUniqNo(123123L)
                .orgPrice(123123)
                .build();

        OriginProduct savedOriginProduct = originProductRepository.save(originProductA);

        //when
        OriginProduct findOriginProduct = originProductRepository.findByProdUniqNo(savedOriginProduct.getProdUniqNo());

        //then
        Assertions.assertThat(findOriginProduct).isEqualTo(originProductA);
    }

}
package com.jiok.purchase.service;

import com.jiok.purchase.domain.originProduct.OriginProduct;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OriginProductServiceTest {

    @Autowired
    OriginProductService originProductService;

    @Test
    public void saveTest() {
        //given
        OriginProduct originProductA = OriginProduct.builder()
                .prodUniqNo(123123L)
                .orgPrice(123123)
                .build();

        //when
        OriginProduct savedOriginProduct = originProductService.save(originProductA);

        //then
        Assertions.assertThat(savedOriginProduct).isEqualTo(originProductA);
    }
}
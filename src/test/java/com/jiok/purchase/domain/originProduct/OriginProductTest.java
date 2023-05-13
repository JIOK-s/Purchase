package com.jiok.purchase.domain.originProduct;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OriginProductTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void originProductTest() {
        OriginProduct originProductA = OriginProduct.builder().build();
        em.persist(originProductA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QOriginProduct originProduct = QOriginProduct.originProduct;
        List<OriginProduct> findOriginProductList = queryFactory
                .select(originProduct)
                .from(originProduct)
                .fetch();

        Assertions.assertThat(findOriginProductList.get(findOriginProductList.size()-1)).isEqualTo(originProductA);
    }
}
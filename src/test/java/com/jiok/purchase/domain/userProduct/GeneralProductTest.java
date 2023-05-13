package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.catalina.users.GenericRole;
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
class GeneralProductTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void generalProductTest() {
        OriginProduct originProductA = OriginProduct.builder()
                .prodUniqNo(11L)
                .build();
        em.persist(originProductA);

        Members membersA = Members.builder()
                .mbrNm("지은리")
                .mbrPhone("01011112222")
                .mbrAddr("양재역")
                .build();
        em.persist(membersA);

        GeneralProduct generalProductA = GeneralProduct.builder()
                .usedPeriod(10)
                .build();
        generalProductA.changeOrginProduct(originProductA);
        generalProductA.changeMembers(membersA);
        em.persist(generalProductA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QGeneralProduct generalProduct = QGeneralProduct.generalProduct;
        List<GeneralProduct> findGeneralProductList = queryFactory
                .select(generalProduct)
                .from(generalProduct)
                .fetch();

        Assertions.assertThat(findGeneralProductList.get(findGeneralProductList.size()-1).getOriginProduct()).isEqualTo(originProductA);
        Assertions.assertThat(findGeneralProductList.get(findGeneralProductList.size()-1)).isEqualTo(generalProductA);
        Assertions.assertThat(findGeneralProductList.get(findGeneralProductList.size()-1).getMembers()).isEqualTo(membersA);
    }

}
package com.jiok.purchase.entity;

import com.querydsl.jpa.impl.JPAQueryFactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;


@SpringBootTest
@Transactional
class CarProductTest {

    @PersistenceContext
    EntityManager em;

//    @BeforeEach
//    public void before() {
//
//        OriginProduct originProductA = new OriginProduct().builder()
//                .prodUniqNo(10L)
//                .build();
//        em.persist(originProductA);
//
//
//        Members membersA = new Members().builder()
//                .mbrNm("옥현지")
//                .mbrPhone("01012341111")
//                .mbrAddr("강남역")
//                .build();
//        em.persist(membersA);
//
//
//        UserProduct userProductA = new UserProduct().builder()
//                .usedPeriod(7)
//                .build();
//        userProductA.changeOrginProduct(originProductA);
//        userProductA.changeMembers(membersA);
//        em.persist(userProductA);
//    }

    @Test
    @DisplayName("querydsl 함")
    public void 쿼리dsl() {
        OriginProduct originProductA = new OriginProduct().builder()
                .prodUniqNo(10L)
                .userProducts(new ArrayList<>())
                .build();
        em.persist(originProductA);


        Members membersA = new Members().builder()
                .mbrNm("옥현지")
                .mbrPhone("01012341111")
                .mbrAddr("강남역")
                .userProducts(new ArrayList<>())
                .build();
        em.persist(membersA);


        UserProduct userProductA = new UserProduct().builder()
                .usedPeriod(7)
                .originProduct(originProductA)
                .members(membersA)
                .build();
        em.persist(userProductA);



        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        QUserProduct userProduct = QUserProduct.userProduct;

        UserProduct findUserProduct = queryFactory
                .select(userProduct)
                .from(userProduct)
                .fetchOne();

        Assertions.assertThat(findUserProduct).isEqualTo(userProductA);
        



    }

}
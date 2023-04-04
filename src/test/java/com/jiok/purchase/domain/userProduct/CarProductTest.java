package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import com.jiok.purchase.domain.userProduct.CarProduct;
import com.jiok.purchase.entity.QCarProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@SpringBootTest
@Transactional
@Commit
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
    public void querydslTest() {
        /* entity setting */
        OriginProduct originProductA = new OriginProduct().builder()
                .prodUniqNo(10L)
                .build();
        em.persist(originProductA);


        Members membersA = new Members().builder()
                .mbrNm("옥현지")
                .mbrPhone("01012341111")
                .mbrAddr("강남역")
                .build();
        em.persist(membersA);


        CarProduct carProductA = new CarProduct().builder()
                .usedPeriod(7)
                .build();
        carProductA.changeOrginProduct(originProductA);
        carProductA.changeMembers(membersA);
        em.persist(carProductA);


        /* JPAQueryFactory setting */
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        /* querydsl 실행 */
        QCarProduct carProduct = QCarProduct.carProduct;
        CarProduct findCarProduct = queryFactory
                .select(carProduct)
                .from(carProduct)
                .fetchOne();

        /* 값 비교 */
        Assertions.assertThat(findCarProduct).isEqualTo(carProductA);
        Assertions.assertThat(findCarProduct.getOriginProduct()).isEqualTo(originProductA);
        Assertions.assertThat(findCarProduct.getMembers()).isEqualTo(membersA);

    }

}
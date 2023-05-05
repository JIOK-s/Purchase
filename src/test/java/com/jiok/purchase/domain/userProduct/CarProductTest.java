package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.marketPrice.MarketPrice;
import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import com.querydsl.jpa.impl.JPAQueryFactory;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@SpringBootTest
@Transactional
class CarProductTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void querydslTest() {
        /* entity setting */
        OriginProduct originProductA = OriginProduct.builder()
                .prodUniqNo(10L)
                .build();
        em.persist(originProductA);


        Members membersA = Members.builder()
                .mbrNm("옥현지")
                .mbrPhone("01012341111")
                .mbrAddr("강남역")
                .build();
        em.persist(membersA);

        MarketPrice marketPriceA = MarketPrice.builder().build();
        em.persist(marketPriceA);

        CarProduct carProductA = CarProduct.builder()
                .usedPeriod(7)
                .build();
        carProductA.changeOrginProduct(originProductA);
        carProductA.changeMembers(membersA);
        carProductA.changeMarketPrice(marketPriceA);
        em.persist(carProductA);

        /* JPAQueryFactory setting */
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        /* querydsl 실행 */
        QCarProduct carProduct = QCarProduct.carProduct;
        List<CarProduct> findCarProductList = queryFactory
                .select(carProduct)
                .from(carProduct)
                .fetch();

        /* 값 비교 */
        Assertions.assertThat(findCarProductList.get(findCarProductList.size()-1)).isEqualTo(carProductA);
        Assertions.assertThat(findCarProductList.get(findCarProductList.size()-1).getOriginProduct()).isEqualTo(originProductA);
        Assertions.assertThat(findCarProductList.get(findCarProductList.size()-1).getMembers()).isEqualTo(membersA);
        Assertions.assertThat(findCarProductList.get(findCarProductList.size()-1).getMarketPrice()).isEqualTo(marketPriceA);

    }

}
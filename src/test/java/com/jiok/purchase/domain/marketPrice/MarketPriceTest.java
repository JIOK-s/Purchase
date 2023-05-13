package com.jiok.purchase.domain.marketPrice;

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
class MarketPriceTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void MarketPriceTest(){
        MarketPrice marketPriceA = MarketPrice.builder().build();
        em.persist(marketPriceA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QMarketPrice marketPrice = QMarketPrice.marketPrice;
        List<MarketPrice> findMarketPriceList = queryFactory
                .select(marketPrice)
                .from(marketPrice)
                .fetch();

        Assertions.assertThat(findMarketPriceList.get(findMarketPriceList.size()-1)).isEqualTo(marketPriceA);
    }

}
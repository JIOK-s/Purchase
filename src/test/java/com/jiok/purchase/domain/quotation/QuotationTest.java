package com.jiok.purchase.domain.quotation;

import com.jiok.purchase.domain.marketPrice.MarketPrice;
import com.jiok.purchase.domain.visitEstimate.VisitEstimate;
import com.jiok.purchase.domain.visitEstimate.VisitEstmProcStCd;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Transactional
class QuotationTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void quotationTest(){
        VisitEstimate visitEstimateA = VisitEstimate.builder()
                                        .visitEstmProcStCd(VisitEstmProcStCd.REQUEST)
                                        .visitEstmProcDtime(LocalDateTime.now())
                                        .build();
        em.persist(visitEstimateA);

        MarketPrice marketPriceA = MarketPrice.builder().build();
        em.persist(marketPriceA);

        Quotation quotationA = Quotation.builder()
                .fennel(Funnel.MOBILE)
                .qutProcStCd(QutProcStCd.REQUEST)
                .build();
        quotationA.changeVisitEstimate(visitEstimateA);
        quotationA.changeMarketPrice(marketPriceA);
        em.persist(quotationA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QQuotation quotation = QQuotation.quotation;
        List<Quotation> findQuotationList = queryFactory
                .select(quotation)
                .from(quotation)
                .fetch();

        Assertions.assertThat(findQuotationList.get(findQuotationList.size()-1)).isEqualTo(quotationA);
        Assertions.assertThat(findQuotationList.get(findQuotationList.size()-1).getVisitEstimate()).isEqualTo(visitEstimateA);
        Assertions.assertThat(findQuotationList.get(findQuotationList.size()-1).getMarketPrice()).isEqualTo(marketPriceA);
    }
}
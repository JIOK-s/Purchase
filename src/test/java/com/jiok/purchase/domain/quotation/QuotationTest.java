package com.jiok.purchase.domain.quotation;

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

        Quotation quotationA = Quotation.builder()
                .fennel(Funnel.MOBILE)
                .qutProcStCd(QutProcStCd.REQUEST)
                .build();

        quotationA.changeVisitEstimate(visitEstimateA);

        em.persist(quotationA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QQuotation quotation = QQuotation.quotation;
        Quotation findQuotation = queryFactory
                .select(quotation)
                .from(quotation)
                .fetchOne();

        Assertions.assertThat(findQuotation).isEqualTo(quotationA);
        Assertions.assertThat(findQuotation.getVisitEstimate()).isEqualTo(visitEstimateA);
    }
}
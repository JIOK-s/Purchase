package com.jiok.purchase.domain.visitEstimate;

import com.jiok.purchase.domain.estimator.Estimator;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class VisitEstimateTest {

    @PersistenceContext
    EntityManager em;

    @Test
    public void visitEstimateTest() {
        Estimator estimatorA = Estimator.builder()
                .estmrNm("지은리")
                .estmrPhone("01023334444")
                .build();
        em.persist(estimatorA);

        VisitEstimate visitEstimateA = VisitEstimate.builder()
                .visitEstmProcStCd(VisitEstmProcStCd.REQUEST)
                .visitEstmProcDtime(LocalDateTime.now())
                .build();

        visitEstimateA.changeEstimator(estimatorA);
        em.persist(visitEstimateA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QVisitEstimate qVisitEstimate = QVisitEstimate.visitEstimate;
        List<VisitEstimate> findVisitEstimateList = queryFactory
                .select(qVisitEstimate)
                .from(qVisitEstimate)
                .fetch();

        Assertions.assertThat(findVisitEstimateList.get(findVisitEstimateList.size()-1)).isEqualTo(visitEstimateA);
        Assertions.assertThat(findVisitEstimateList.get(findVisitEstimateList.size()-1).getEstimator()).isEqualTo(estimatorA);
    }
}
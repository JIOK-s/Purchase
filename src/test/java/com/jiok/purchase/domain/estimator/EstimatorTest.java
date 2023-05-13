package com.jiok.purchase.domain.estimator;

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
class EstimatorTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void EstimatorTest(){

        Estimator estimatorA = Estimator.builder().build();
        em.persist(estimatorA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QEstimator estimator = QEstimator.estimator;
        List<Estimator> findEstimatorList = queryFactory
                .select(estimator)
                .from(estimator)
                .fetch();

        Assertions.assertThat(findEstimatorList.get(findEstimatorList.size()-1)).isEqualTo(estimatorA);
    }

}
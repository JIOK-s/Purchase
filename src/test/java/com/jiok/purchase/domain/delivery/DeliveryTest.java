package com.jiok.purchase.domain.delivery;

import com.jiok.purchase.domain.contract.Contract;
import com.jiok.purchase.domain.contract.NmDivdCd;
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
class DeliveryTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void deliveryTest() {
        Contract contractA = Contract.builder()
                .build();
        em.persist(contractA);

        Delivery deliveryA = Delivery
                .builder()
                .dlvProcStCd(DlvProcStCd.DELIVERY_ORDER)
                .build();
        deliveryA.changeContract(contractA);
        em.persist(deliveryA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QDelivery delivery = QDelivery.delivery;
        List<Delivery> findDeliveryList = queryFactory
                .select(delivery)
                .from(delivery)
                .fetch();

        Assertions.assertThat(findDeliveryList.get(findDeliveryList.size()-1)).isEqualTo(deliveryA);
        Assertions.assertThat(findDeliveryList.get(findDeliveryList.size()-1).getDlvProcStCd().getCode()).isEqualTo(DlvProcStCd.DELIVERY_ORDER.getCode());
        Assertions.assertThat(findDeliveryList.get(findDeliveryList.size()-1).getContract()).isEqualTo(contractA);
    }
}
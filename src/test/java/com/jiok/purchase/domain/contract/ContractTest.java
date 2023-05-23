package com.jiok.purchase.domain.contract;

import com.jiok.purchase.domain.quotation.Funnel;
import com.jiok.purchase.domain.quotation.Quotation;
import com.jiok.purchase.domain.quotation.QutProcStCd;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootTest
@Transactional
public class ContractTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void ContractTest(){

        Quotation quotationA = Quotation.builder()
                .fennel(Funnel.MOBILE)
                .qutProcStCd(QutProcStCd.REQUEST)
                .build();
        em.persist(quotationA);

        Contract contractA = Contract.builder()
                .nmDivdCd(NmDivdCd.PERSONAL)
                .build();
        contractA.changeQuotation(quotationA);
        em.persist(contractA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QContract contract = QContract.contract;
        List<Contract> findContractList = queryFactory
                .select(contract)
                .from(contract)
                .fetch();

        Assertions.assertThat(findContractList.get(findContractList.size()-1)).isEqualTo(contractA);
        Assertions.assertThat(findContractList.get(findContractList.size()-1).getNmDivdCd().getCode()).isEqualTo(NmDivdCd.PERSONAL.getCode());
        Assertions.assertThat(findContractList.get(findContractList.size()-1).getQuotation()).isEqualTo(quotationA);

    }

}

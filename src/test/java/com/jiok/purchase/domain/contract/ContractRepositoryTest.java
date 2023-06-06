package com.jiok.purchase.domain.contract;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContractRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    ContractRepository contractRepository;

    @Test
    public void ContractRepositorySaveTest() {
        //given
        Contract contractA = Contract.builder()
                .contrDtime(LocalDateTime.now())
                .contrPrice(10000.0)
                .contrAccntNo("1233455666")
                .contrAccntNm("미스옥")
                .contrCmplYn(false)
                .contrDlvYn(false)
                .contrPayDtime(LocalDateTime.now())
                .nmDivdCd(NmDivdCd.PERSONAL)
                .build();

        Contract savedContract = contractRepository.save(contractA);

        //when
        Contract findContract = contractRepository.findByContractNo(savedContract.getContrNo());

        //then
        Assertions.assertThat(savedContract).isEqualTo(contractA);
    }
}
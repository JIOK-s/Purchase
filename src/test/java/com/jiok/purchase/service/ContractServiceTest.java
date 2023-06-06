package com.jiok.purchase.service;

import com.jiok.purchase.domain.contract.Contract;
import com.jiok.purchase.domain.contract.NmDivdCd;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ContractServiceTest {

    @Autowired
    ContractService contractService;

    @Test
    public void saveTest() {
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

        //when
        Contract savedContract = contractService.save(contractA);

        //then
        Assertions.assertThat(savedContract).isEqualTo(contractA);
    }
}
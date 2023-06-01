package com.jiok.purchase.service;

import com.jiok.purchase.domain.members.Members;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MembersServiceTest {

    @Autowired
    MembersService membersService;

    @Test
    public void saveTest(){
        //given
        Members membersA = Members.builder()
                .mbrNm("옥자")
                .mbrPhone("01012341234")
                .mbrAddr("서울특별시 동대문구 신설동")
                .mbrDtlAddr("동대문구청 101동 101호")
                .build();

        //when
        Members savedMembers = membersService.save(membersA);

        //then
        Assertions.assertThat(savedMembers).isEqualTo(membersA);
    }
}
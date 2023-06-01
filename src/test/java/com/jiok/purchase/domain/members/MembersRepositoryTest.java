package com.jiok.purchase.domain.members;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@SpringBootTest
@Transactional
class MembersRepositoryTest {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    MembersRepository membersRepository;

    @Test
    public void MembersRepositorySaveTest() {
        //given
        Members membersA = Members.builder()
                .mbrNm("옥자")
                .mbrPhone("01012341234")
                .mbrAddr("서울특별시 동대문구 신설동")
                .mbrDtlAddr("동대문구청 101동 101호")
                .build();

        //when
        Members savedMbrId = membersRepository.save(membersA);

        //then
        Assertions.assertThat(savedMbrId).isEqualTo(membersA);
    }

    @Test
    public void MembersRepositoryFindByMbrPhoneTest() {
        //given
        Members membersA = Members.builder()
                .mbrNm("옥자")
                .mbrPhone("01012341234")
                .mbrAddr("서울특별시 동대문구 신설동")
                .mbrDtlAddr("동대문구청 101동 101호")
                .build();

        Members savedMembers = membersRepository.save(membersA);

        //when
        Members findMembers = membersRepository.findByMbrPhone(savedMembers.getMbrPhone());

        //then
        Assertions.assertThat(findMembers).isEqualTo(membersA);
    }

}
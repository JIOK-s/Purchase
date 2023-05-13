package com.jiok.purchase.domain.members;

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
class MembersTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    public void MembersTest(){
        Members membersA = Members.builder().build();
        em.persist(membersA);

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QMembers members = QMembers.members;
        List<Members> findMembersList = queryFactory
                .select(members)
                .from(members)
                .fetch();

        Assertions.assertThat(findMembersList.get(findMembersList.size()-1)).isEqualTo(membersA);

    }

}
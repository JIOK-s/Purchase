package com.jiok.purchase.domain.members;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MembersRepositoryImpl implements MembersRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Members findByMbrId(Long reqMbrId) {

        QMembers members = QMembers.members;

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        Members findByMbrId = queryFactory
                .select(members)
                .from(members)
                .where(members.mbrId.eq(reqMbrId))
                .fetchOne();

        return findByMbrId;
    }

    @Override
    public Long save(Members reqMembers) {

        em.persist(reqMembers);

        return reqMembers.getMbrId();
    }


}

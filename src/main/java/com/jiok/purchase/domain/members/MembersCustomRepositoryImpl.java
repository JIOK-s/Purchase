package com.jiok.purchase.domain.members;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MembersCustomRepositoryImpl implements MembersCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Members findByMbrPhone(String reqMbrPhone) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QMembers members = QMembers.members;

        Members findByMbrId = queryFactory
                .select(members)
                .from(members)
                .where(members.mbrPhone.eq(reqMbrPhone))
                .fetchOne();

        return findByMbrId;
    }


}

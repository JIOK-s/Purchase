package com.jiok.purchase.domain.contract;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ContractCustomRepositoryImpl implements ContractCustomRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Contract findByContractNo(Long contrNo) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QContract contract = QContract.contract;

        Contract findByContrNo = queryFactory
                .select(contract)
                .from(contract)
                .where(contract.contrNo.eq(contrNo))
                .fetchOne();

        return findByContrNo;
    }
}

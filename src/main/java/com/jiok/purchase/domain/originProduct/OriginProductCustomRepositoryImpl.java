package com.jiok.purchase.domain.originProduct;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.members.QMembers;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class OriginProductCustomRepositoryImpl implements OriginProductCustomRepository{

    @PersistenceContext
    private EntityManager em;

    @Override
    public OriginProduct findByProdUniqNo(Long prodUniqNo) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        QOriginProduct originProduct = QOriginProduct.originProduct;

        OriginProduct findByProdUniqNo = queryFactory
                .select(originProduct)
                .from(originProduct)
                .where(originProduct.prodUniqNo.eq(prodUniqNo))
                .fetchOne();

        return findByProdUniqNo;
    }
}

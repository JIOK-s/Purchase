package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.members.QMembers;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class GeneralProductCustomRepositoryImpl implements GeneralProductCustomRepository{

    @PersistenceContext
    private EntityManager em;

    private final QGeneralProduct generalProduct = QGeneralProduct.generalProduct;
    private final QMembers members = QMembers.members;

    @Override
    public List<GeneralProduct> findUserProductManagement(GeneralProduct paramGeneralProduct) {
        JPAQueryFactory queryFactory = new JPAQueryFactory(em);

        return queryFactory
                .select(generalProduct)
                .from(generalProduct)
                .join(generalProduct.members, members)
                .where(
                        userProdNoEq(paramGeneralProduct.getUserProdNo()),
                        usedPeriodEq(paramGeneralProduct.getUsedPeriod()),
                        mbrIdEq(paramGeneralProduct.getMembers()==null ? null : paramGeneralProduct.getMembers().getMbrId())
                )
                .fetch();
    }

    private BooleanExpression userProdNoEq(Long userProdNo) {
        if (userProdNo == null) {
            return null;
        }
        return generalProduct.userProdNo.eq(userProdNo);
    }

    private BooleanExpression usedPeriodEq(Integer usedPeriod) {
        if (usedPeriod == null) {
            return null;
        }
        return generalProduct.usedPeriod.eq(usedPeriod);
    }

    private BooleanExpression mbrIdEq(Long mbrId) {
        if (mbrId == null) {
            return null;
        }
        return generalProduct.members.mbrId.eq(mbrId);
    }
}

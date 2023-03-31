package com.jiok.purchase.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user_product")
@ToString
@NoArgsConstructor
@Getter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn
public abstract class UserProduct {

    @Id
    @GeneratedValue
    @Column(name = "user_prod_no")
    private Long userProdNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prod_no")
    private OriginProduct originProduct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mbr_id")
    private Members members;

    private Integer usedPeriod;

    public UserProduct(Long userProdNo, OriginProduct originProduct, Members members, Integer usedPeriod) {
        this.userProdNo = userProdNo;
        this.usedPeriod = usedPeriod;
    }

    /* 연관관계 mapping */
    public void changeOrginProduct(OriginProduct originProduct) {
        this.originProduct = originProduct;
        originProduct.getUserProducts().add(this);
    }

    public void changeMembers(Members members) {
        this.members = members;
        members.getUserProducts().add(this);
    }


}
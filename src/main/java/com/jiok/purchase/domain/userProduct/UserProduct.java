package com.jiok.purchase.domain.userProduct;

import com.jiok.purchase.domain.marketPrice.MarketPrice;
import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.originProduct.OriginProduct;
import lombok.*;

import javax.persistence.*;

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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mp_no")
    private MarketPrice marketPrice;

    public UserProduct(Long userProdNo, OriginProduct originProduct, Members members, Integer usedPeriod, MarketPrice marketPrice) {
        this.userProdNo = userProdNo;
        this.originProduct = originProduct;
        this.members = members;
        this.usedPeriod = usedPeriod;
        this.marketPrice = marketPrice;
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

    public void changeMarketPrice(MarketPrice marketPrice) {
        this.marketPrice = marketPrice;
        marketPrice.changeUserProduct(this);
    }


}
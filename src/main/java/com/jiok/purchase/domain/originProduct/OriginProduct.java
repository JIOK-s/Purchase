package com.jiok.purchase.domain.originProduct;


import com.jiok.purchase.domain.userProduct.UserProduct;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "origin_product")
@Getter
@ToString
@NoArgsConstructor
public class OriginProduct {

    @Id
    @GeneratedValue
    @Column(name="prod_no")
    private Long prodNo;

    private Long prodUniqNo;

    private Integer orgPrice;

    @OneToMany(mappedBy = "originProduct")
    private List<UserProduct> userProducts = new ArrayList<>();

    @Builder
    public OriginProduct(Long prodNo, Long prodUniqNo, Integer orgPrice) {
        this.prodNo = prodNo;
        this.prodUniqNo = prodUniqNo;
        this.orgPrice = orgPrice;
    }
}

package com.jiok.purchase.entity;


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
    public OriginProduct(Long prodNo, Long prodUniqNo, Integer orgPrice, List<UserProduct> userProducts) {
        this.prodNo = prodNo;
        this.prodUniqNo = prodUniqNo;
        this.orgPrice = orgPrice;
    }
}

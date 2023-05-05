package com.jiok.purchase.domain.marketPrice;

import com.jiok.purchase.domain.quotation.Quotation;
import com.jiok.purchase.domain.userProduct.UserProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "market_price")
@Getter
@ToString
@NoArgsConstructor
public class MarketPrice {

    @Id
    @GeneratedValue
    @Column(name = "mp_no")
    private Long mpNo;

    @OneToOne(mappedBy = "marketPrice")
    private UserProduct userProduct;

    private Double usedPrice;

    @OneToOne(mappedBy = "marketPrice")
    private Quotation quotation;

    @Builder
    public MarketPrice(Long mpNo, Double usedPrice) {
        this.mpNo = mpNo;
        this.usedPrice = usedPrice;
    }

    public void changeUserProduct(UserProduct userProduct) {
        this.userProduct = userProduct;
    }

    public void changeQuotation(Quotation quotation) {
        this.quotation = quotation;
    }

}

package com.jiok.purchase.domain.quotation;

import com.jiok.purchase.domain.marketPrice.MarketPrice;
import com.jiok.purchase.domain.visitEstimate.VisitEstimate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "quotation")
@NoArgsConstructor
@Getter
@ToString
public class Quotation {

    @Id @GeneratedValue
    @Column(name = "qut_no")
    private Long qutNo;

    @Enumerated(EnumType.STRING)
    private Funnel fennel;

    @Enumerated(EnumType.STRING)
    private QutProcStCd qutProcStCd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_estm_no")
    private VisitEstimate visitEstimate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mp_no")
    private MarketPrice marketPrice;

    @Builder
    public Quotation(Long qutNo, Funnel fennel, QutProcStCd qutProcStCd, VisitEstimate visitEstimate, MarketPrice marketPrice) {
        this.qutNo = qutNo;
        this.fennel = fennel;
        this.qutProcStCd = qutProcStCd;
        this.visitEstimate = visitEstimate;
        this.marketPrice = marketPrice;
    }

    public void changeVisitEstimate(VisitEstimate visitEstimate) {
        this.visitEstimate = visitEstimate;
        visitEstimate.getQuotations().add(this);
    }

    public void changeMarketPrice(MarketPrice marketPrice) {
        this.marketPrice = marketPrice;
        marketPrice.changeQuotation(this);
    }
}



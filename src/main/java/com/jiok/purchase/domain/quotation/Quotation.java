package com.jiok.purchase.domain.quotation;

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

    @Builder
    public Quotation(Long qutNo, Funnel fennel, QutProcStCd qutProcStCd) {
        this.qutNo = qutNo;
        this.fennel = fennel;
        this.qutProcStCd = qutProcStCd;
    }

    public void changeVisitEstimate(VisitEstimate visitEstimate) {
        this.visitEstimate = visitEstimate;
        visitEstimate.getQuotations().add(this);
    }
}



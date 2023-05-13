package com.jiok.purchase.domain.contract;

import com.jiok.purchase.domain.delivery.Delivery;
import com.jiok.purchase.domain.quotation.Quotation;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contract")
@Getter
@ToString
@NoArgsConstructor
public class Contract {

    @Id
    @GeneratedValue
    @Column(name = "contr_no")
    private Long contrNo;

    private LocalDateTime contrDtime;

    private Double contrPrice;

    private String contrAccntNo;

    private String contrAccntNm;

    private Boolean contrCmplYn;

    private Boolean contrDlvYn;

    private LocalDateTime contrPayDtime;

    @Enumerated(EnumType.STRING)
    private NmDivdCd nmDivdCd;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "qut_no")
    private Quotation quotation;

    @OneToOne(mappedBy = "contract")
    private Delivery delivery;

    @Builder
    public Contract(Long contrNo, LocalDateTime contrDtime, Double contrPrice, String contrAccntNo, String contrAccntNm, Boolean contrCmplYn, Boolean contrDlvYn, LocalDateTime contrPayDtime, NmDivdCd nmDivdCd, Quotation quotation) {
        this.contrNo = contrNo;
        this.contrDtime = contrDtime;
        this.contrPrice = contrPrice;
        this.contrAccntNo = contrAccntNo;
        this.contrAccntNm = contrAccntNm;
        this.contrCmplYn = contrCmplYn;
        this.contrDlvYn = contrDlvYn;
        this.contrPayDtime = contrPayDtime;
        this.nmDivdCd = nmDivdCd;
        this.quotation = quotation;
    }
    
    public void changeQuotation(Quotation quotation) {
        this.quotation = quotation;
        quotation.changeContract(this);
    }

    public void changeDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}

package com.jiok.purchase.domain.delivery;

import com.jiok.purchase.domain.contract.Contract;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
@Getter
@ToString
@NoArgsConstructor
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "dlv_no")
    private Long dlvNo;

    @Enumerated(EnumType.STRING)
    private DlvProcStCd dlvProcStCd;

    private String dlvEntr;

    private LocalDateTime dlvStartDtime;

    private LocalDateTime dlvEndDtime;

    private String shipNo;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contr_no")
    private Contract contract;

    @Builder
    public Delivery(Long dlvNo, DlvProcStCd dlvProcStCd, String dlvEntr, LocalDateTime dlvStartDtime, LocalDateTime dlvEndDtime, String shipNo, Contract contract) {
        this.dlvNo = dlvNo;
        this.dlvProcStCd = dlvProcStCd;
        this.dlvEntr = dlvEntr;
        this.dlvStartDtime = dlvStartDtime;
        this.dlvEndDtime = dlvEndDtime;
        this.shipNo = shipNo;
        this.contract = contract;
    }

    public void changeContract(Contract contract) {
        this.contract = contract;
        contract.changeDelivery(this);
    }
}

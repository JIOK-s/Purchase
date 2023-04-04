package com.jiok.purchase.domain.visitEstimate;

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
@Table(name = "visit_estimate")
@Getter
@ToString
@NoArgsConstructor
public class VisitEstimate {

    @Id @GeneratedValue
    @Column(name = "visit_estm_no")
    private Long visitEstmNo;

    @Enumerated(EnumType.STRING)
    private VisitEstmProcStCd visitEstmProcStCd;

    private LocalDateTime visitEstmProcDtime;

    @OneToMany(mappedBy = "visitEstimate")
    private List<Quotation> quotations = new ArrayList<>();

    @Builder
    public VisitEstimate(Long visitEstmNo, VisitEstmProcStCd visitEstmProcStCd, LocalDateTime visitEstmProcDtime) {
        this.visitEstmNo = visitEstmNo;
        this.visitEstmProcStCd = visitEstmProcStCd;
        this.visitEstmProcDtime = visitEstmProcDtime;
    }
}

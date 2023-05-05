package com.jiok.purchase.domain.estimator;

import com.jiok.purchase.domain.visitEstimate.VisitEstimate;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "estimator")
@Getter
@ToString
@NoArgsConstructor
public class Estimator {

    @Id
    @GeneratedValue
    @Column(name = "estmr_id")
    private Long estmrId;

    private String estmrNm;

    private String estmrPhone;

    @Enumerated(EnumType.STRING)
    private EstmrLoc estmrLoc;

    @OneToMany(mappedBy = "estimator")
    private List<VisitEstimate> visitEstimateList = new ArrayList<>();

    @Builder
    public Estimator(Long estmrId, String estmrNm, String estmrPhone, EstmrLoc estmrLoc) {
        this.estmrId = estmrId;
        this.estmrNm = estmrNm;
        this.estmrPhone = estmrPhone;
        this.estmrLoc = estmrLoc;
    }
}

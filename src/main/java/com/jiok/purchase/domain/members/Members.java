package com.jiok.purchase.domain.members;

import com.jiok.purchase.domain.userProduct.UserProduct;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "members")
@Getter
@ToString
@NoArgsConstructor
public class Members {

    @Id
    @GeneratedValue
    @Column(name = "mbr_id")
    private Long mbrId;

    private String mbrNm;

    private String mbrPhone;

    private String mbrAddr;

    @OneToMany(mappedBy = "members")
    private List<UserProduct> userProducts = new ArrayList<>();

    @Builder
    public Members(Long mbrId, String mbrNm, String mbrPhone, String mbrAddr) {
        this.mbrId = mbrId;
        this.mbrNm = mbrNm;
        this.mbrPhone = mbrPhone;
        this.mbrAddr = mbrAddr;
    }
}

package com.jiok.purchase.domain.members;

public interface MembersCustomRepository {

    public Members findByMbrPhone(String mbrPhone);

}

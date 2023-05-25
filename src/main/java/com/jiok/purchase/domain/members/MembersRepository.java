package com.jiok.purchase.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository {

    public Members findByMbrId(Long mbrId);

    public Long save(Members reqMembers);

}

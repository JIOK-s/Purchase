package com.jiok.purchase.domain.members;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepository extends JpaRepository<Members, Long>, MembersCustomRepository {



}

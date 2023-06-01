package com.jiok.purchase.service;

import com.jiok.purchase.domain.members.Members;
import com.jiok.purchase.domain.members.MembersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.PersistenceContext;

@Service
public class MembersService {

    @Autowired
    MembersRepository membersRepository;

    public Members save(Members members) {
        return membersRepository.save(members);
    }

}

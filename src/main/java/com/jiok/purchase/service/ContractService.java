package com.jiok.purchase.service;

import com.jiok.purchase.domain.contract.Contract;
import com.jiok.purchase.domain.contract.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContractService {

    @Autowired
    ContractRepository contractRepository;

    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

}

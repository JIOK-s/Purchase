package com.jiok.purchase.domain.contract;

public interface ContractCustomRepository {
    public Contract findByContractNo(Long contrNo);
}

package com.jiok.purchase.domain.originProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OriginProductRepository extends JpaRepository<OriginProduct, Long>, OriginProductCustomRepository {

}

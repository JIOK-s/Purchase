package com.jiok.purchase.domain.userProduct;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GeneralProductRepository extends JpaRepository<GeneralProduct, Long>, GeneralProductCustomRepository {
}

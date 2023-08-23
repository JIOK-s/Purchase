package com.jiok.purchase.domain.userProduct;

import java.util.List;

public interface GeneralProductCustomRepository {

    public List<GeneralProduct> findUserProductManagement(GeneralProduct paramGeneralProduct);
}

package com.dw.dao.oracle;

import com.dw.model.oracle.ProductsOracle;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface ProductsDAO {
    public List<ProductsOracle> readProducts();
    public List<ProductsOracle> save(List<ProductsOracle> productsOracles);
}

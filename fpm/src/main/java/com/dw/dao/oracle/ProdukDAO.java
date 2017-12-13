package com.dw.dao.oracle;

import com.dw.model.oracle.ProdukOracle;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface ProdukDAO {
    public List<ProdukOracle> readProduk();
    public List<ProdukOracle> save(List<ProdukOracle> produkOracles);
}

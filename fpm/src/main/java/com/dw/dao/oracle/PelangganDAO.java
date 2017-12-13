package com.dw.dao.oracle;

import com.dw.model.oracle.PelangganOracle;

import java.util.List;

/**
 * Created by Pinky Cindy on 12/12/17.
 */
public interface PelangganDAO {
    public List<PelangganOracle> readPelanggan();
    public List<PelangganOracle> save(List<PelangganOracle> pelangganOracles);

}

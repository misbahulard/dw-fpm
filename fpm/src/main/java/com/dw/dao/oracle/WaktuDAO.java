package com.dw.dao.oracle;

import com.dw.model.oracle.WaktuOracle;

import java.util.List;

public interface WaktuDAO {
    public List<WaktuOracle> readWaktu();
    public List<WaktuOracle> save(List<WaktuOracle> waktuOracles);
}

-- DDL FOR MYSQL
create table t_barang_new as select * from retail.t_barang_new where 1 = 2;
create table t_customer_new as select * from retail.t_customer_new where 1 = 2;
create table t_det_jual as select * from retail.t_det_jual where 1 = 2;

-- create table t_barang as select * from retail.t_barang limit 1;
-- create table t_customer as select * from retail.t_customer limit 1;
-- create table t_jns_brg as select * from retail.t_jns_brg limit 1;
-- create table t_jual as select * from retail.t_jual limit 1;

-- CREATE TABEL BARANG NEW
CREATE TABLE `t_barang_new` (
  `id_new` int(10) NOT NULL AUTO_INCREMENT,
  `id_old` char(10) NOT NULL DEFAULT '0',
  `nama` char(25) NOT NULL DEFAULT '0',
  `jns_brg` char(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id_new`)
) ENGINE=InnoDB AUTO_INCREMENT=70000 DEFAULT CHARSET=latin1;

-- POPULATE TABLE BARANG NEW
INSERT INTO t_barang_new (id_old, nama, jns_brg) SELECT B.ID, B.NAMA, J.JENIS FROM T_BARANG B, T_JNS_BRG J WHERE B.JNS_BRG = J.ID;

-- CREATE TABLE CUSTOMER NEW
CREATE TABLE `t_customer_new` (
  `id_new` int(10) NOT NULL AUTO_INCREMENT,
  `id_old` varchar(10) NOT NULL DEFAULT '0',
  `nama` varchar(25) DEFAULT '0',
  `alamat` varchar(35) DEFAULT '0',
  `kota` varchar(5) DEFAULT '0',
  PRIMARY KEY (`id_new`)
) ENGINE=InnoDB AUTO_INCREMENT=700000 DEFAULT CHARSET=latin1;

-- POPULATE CUSTOMER NEW
INSERT INTO T_CUSTOMER_NEW (ID_OLD, NAMA, ALAMAT, KOTA) SELECT ID, NAMA, ALMAT, KOTA FROM T_CUSTOMER;

-- CREATE TABLE WAKTU (BANTUAN ID WAKTU)
CREATE TABLE `t_waktu` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tgl` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9000 DEFAULT CHARSET=latin1;

INSERT INTO t_waktu (TGL) SELECT DISTINCT TGl_NOTA FROM T_JUAL ORDER BY TGL_NOTA ASC;

-- CREATE TABLE JUAL_NEW (ADA ID_TGL)
CREATE TABLE `t_jual_new` (
  `nota` bigint(10) NOT NULL DEFAULT '0',
  `id_tgl` int(10) NOT NULL DEFAULT '0',
  `tgl_nota` date DEFAULT '0000-00-00',
  `cust` varchar(10) DEFAULT '0',
  PRIMARY KEY (`nota`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- POPULATE TABLE JUAL NEW
INSERT INTO T_JUAL_NEW (NOTA, ID_TGL, TGL_NOTA, CUST)
SELECT J.NOTA, W.ID, J.TGL_NOTA, J.CUST FROM T_JUAL J
LEFT JOIN T_WAKTU W ON J.TGL_NOTA = W.TGL;

-- CREATE TABLE PENJUALAN
CREATE TABLE `t_penjualan` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NO_PRODUK` int(10) DEFAULT '0',
  `NO_PELANGGAN` int(10) DEFAULT '0',
  `NO_WAKTU` int(10) DEFAULT '0',
  `JUMLAH_PENJUALAN` bigint(21) unsigned DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `penjualan_idx` (`NO_PRODUK`,`NO_PELANGGAN`,`NO_WAKTU`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- INSERT TABLE PENJUALAN (UNTUK DW)
INSERT INTO t_penjualan (NO_PRODUK, NO_PELANGGAN, NO_WAKTU, JUMLAH_PENJUALAN)
SELECT 
	b.id_new AS NO_PRODUK,
    c.id_new NO_PELANGGAN,
    j.id_tgl AS NO_WAKTU,
    (d.jml_bsr + d.jml_kcl) AS JUMLAH_PENJUALAN
FROM
    t_det_jual d
LEFT JOIN t_jual_new j ON d.nota = j.nota
LEFT JOIN t_barang_new b ON d.id_brg = b.id_old
LEFT JOIN t_customer_new c ON j.cust = c.id_old;

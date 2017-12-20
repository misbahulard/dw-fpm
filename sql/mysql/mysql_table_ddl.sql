USE retail;

DROP TABLE IF EXISTS t_barang;
CREATE TABLE IF NOT EXISTS t_barang (id char(10) NOT NULL DEFAULT '0', jns_psr char(6) NOT NULL DEFAULT '0', no char(15) NOT NULL DEFAULT '0', nama char(25) NOT NULL DEFAULT '0', jns_brg char(6) NOT NULL DEFAULT '', hrg_beli bigint(12) unsigned NOT NULL DEFAULT '0', sat_bsr char(5) NOT NULL DEFAULT '', hrg_bsr bigint(12) NOT NULL DEFAULT '0', sat_kcl char(5) NOT NULL DEFAULT '', hrg_kcl bigint(12) unsigned NOT NULL DEFAULT '0', isi bigint(12) unsigned NOT NULL DEFAULT '0', supplier char(6) NOT NULL DEFAULT '', kritis bigint(12) unsigned NOT NULL DEFAULT '0', stock bigint(12) unsigned NOT NULL DEFAULT '0', PRIMARY KEY (id,jns_psr), KEY idx_t_barang (id,supplier,nama,no,jns_brg,jns_psr));

DROP TABLE IF EXISTS t_customer;
CREATE TABLE IF NOT EXISTS t_customer (id varchar(10) NOT NULL DEFAULT '0', jenis varchar(5) DEFAULT '0', nama varchar(25) DEFAULT '0', almat varchar(30) DEFAULT '0', kota varchar(5) DEFAULT '0', kdpos varchar(6) DEFAULT '0', notel varchar(15) DEFAULT '0', hp varchar(15) DEFAULT '0', nofax varchar(15) DEFAULT '0', url varchar(20) DEFAULT '0', email varchar(20) DEFAULT '0', PRIMARY KEY (id), KEY idx_t_customer (id,jenis,kota));

DROP TABLE IF EXISTS t_det_jual;
CREATE TABLE IF NOT EXISTS t_det_jual (nota bigint(10) DEFAULT '0', id_brg varchar(10) DEFAULT '0', jml_bsr bigint(8) DEFAULT '0', jml_kcl bigint(8) unsigned DEFAULT '0', hrg_bsr bigint(12) unsigned DEFAULT '0', hrg_kcl bigint(12) unsigned DEFAULT '0', tipe char(1) DEFAULT '0', disc1 varchar(12) DEFAULT '0.00', disc2 varchar(12) DEFAULT '0.00', total bigint(12) unsigned DEFAULT '0', KEY idx_t_det_jual (nota,tipe,id_brg));

DROP TABLE IF EXISTS t_jns_brg;
CREATE TABLE IF NOT EXISTS t_jns_brg (id varchar(6) NOT NULL DEFAULT '0', jenis varchar(20) NOT NULL DEFAULT '0', PRIMARY KEY (id,jenis));

DROP TABLE IF EXISTS t_jns_cust;
CREATE TABLE IF NOT EXISTS t_jns_cust (id varchar(5) NOT NULL DEFAULT '0', jenis varchar(25) NOT NULL DEFAULT '0', PRIMARY KEY (id,jenis));

DROP TABLE IF EXISTS t_jns_sales;
CREATE TABLE IF NOT EXISTS t_jns_sales (id varchar(5) NOT NULL DEFAULT '0', jenis varchar(25) NOT NULL DEFAULT '0', PRIMARY KEY (id,jenis));

DROP TABLE IF EXISTS t_jual;
CREATE TABLE IF NOT EXISTS t_jual (nota bigint(10) DEFAULT '0', tgl_nota date DEFAULT '0000-00-00', sales varchar(5) DEFAULT '0', cust varchar(10) DEFAULT '0', pasar varchar(5) DEFAULT '0', cara char(1) DEFAULT '0', tempo date DEFAULT '0000-00-00', total bigint(12) unsigned DEFAULT '0', disc bigint(12) unsigned DEFAULT '0', KEY idx_tj_jual (cust,cara,nota,pasar,sales,tgl_nota));

DROP TABLE IF EXISTS t_kota;
CREATE TABLE IF NOT EXISTS t_kota (id varchar(5) NOT NULL DEFAULT '0', kota varchar(25) NOT NULL DEFAULT '0', PRIMARY KEY (id,kota));

DROP TABLE IF EXISTS t_sales;
CREATE TABLE IF NOT EXISTS t_sales (id varchar(5) NOT NULL DEFAULT '0', nama varchar(25) DEFAULT '0', jenis varchar(10) DEFAULT '0', alamat varchar(30) DEFAULT '0', notel varchar(15) DEFAULT '0', hp varchar(15) DEFAULT '0', kota varchar(5) DEFAULT '0', PRIMARY KEY (id), KEY idx_t_sales (id,jenis,notel));

DROP TABLE IF EXISTS t_supplier;
CREATE TABLE IF NOT EXISTS t_supplier (id varchar(6) NOT NULL DEFAULT '0', nama varchar(25) NOT NULL DEFAULT '0', alamat varchar(30) DEFAULT '0', kota varchar(5) DEFAULT '0', kdpos varchar(6) DEFAULT '0', notel varchar(15) DEFAULT '0', hp varchar(15) DEFAULT '0', nofax varchar(15) DEFAULT '0', url varchar(20) DEFAULT '0', email varchar(20) DEFAULT '0', PRIMARY KEY (id,nama), KEY idx_t_supplier (id,nama));
package com.iuh.dao;


import com.iuh.entity.ChiTietDV;

public interface ChiTietDichVuDAO {
	
	public ChiTietDV getChiTietDV(String maPhieuDatPhong, String MaDV);
    public void saveCTDV(ChiTietDV ctp);
    public void updateCTDV(ChiTietDV cthd, String maPhieuDatPhong, String MaDV);
    public void deleteCTDV(String maPhieuDatPhong, String MaDV);

}

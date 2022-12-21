package com.se.service;

import com.se.entity.ChiTietDV;

public interface ChiTietDichVuService {
	
	public ChiTietDV getChiTietDV(String maPhieuDatPhong, String MaDV);
    public void saveCTDV(ChiTietDV ctp);
    public void updateCTDV(Integer soLanSuDung, String maPhieuDatPhong, String MaDV);
    public void deleteCTDV(String maPhieuDatPhong, String MaDV);

}

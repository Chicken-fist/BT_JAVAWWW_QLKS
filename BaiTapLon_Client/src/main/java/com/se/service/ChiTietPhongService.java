package com.se.service;

import java.util.List;

import com.se.entity.ChiTietPhong;
import com.se.entity.PhieuDatPhong;

public interface ChiTietPhongService {
	
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong);
    public void saveCTP(ChiTietPhong ctdv);
    public void updateCTP(ChiTietPhong ctdv, String maPhieuDatPhong, String maPhong);
    public void deleteCTP(String maPhieuDatPhong, String maPhong);
    public PhieuDatPhong getPhieuDatPhongTheoMaPhong(String maPhong);

}

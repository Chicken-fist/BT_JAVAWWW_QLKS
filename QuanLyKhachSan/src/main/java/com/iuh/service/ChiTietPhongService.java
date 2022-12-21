package com.iuh.service;



import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;

public interface ChiTietPhongService {
	
	public PhieuDatPhong getChiTietPhongTheoMaPhong(String maPhong);
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong);
    public void saveCTP(ChiTietPhong ctp);
    public void updateCTP(ChiTietPhong ctdv, String maPhieuDatPhong, String maPhong);
    public void deleteCTP(String maPhieuDatPhong, String maPhong);

}

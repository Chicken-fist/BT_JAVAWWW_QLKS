package com.iuh.dao;


import java.util.Date;
import java.util.List;

import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;

public interface ChiTietPhongDAO {
	
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong);
	public PhieuDatPhong getChiTietPhongTheoMaPhong(String maPhong);
    public void saveCTP(ChiTietPhong ctp);
    public void updateCTP(ChiTietPhong ctdv, String maPhieuDatPhong, String maPhong);
    public void deleteCTP(String maPhieuDatPhong, String maPhong);
    

}

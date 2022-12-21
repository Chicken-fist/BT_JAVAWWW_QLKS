/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.dao;

import java.util.List;

import com.iuh.entity.PhieuDatPhong;


/**
 *
 * @author DangNguyen
 */
public interface PhieuDatPhongDAO {
	
	public List<PhieuDatPhong> getPhieuDatPhongs();
    public PhieuDatPhong getPhieuDatPhong(String phieuDatPhongId);
    public void savePhieuDatPhong(PhieuDatPhong phieuDatPhong);
    public void updatePhieuDatPhong(PhieuDatPhong phieuDatPhong);
    public void deletePhieuDatPhong(String phieuDatPhongId);
    public List<PhieuDatPhong> getPhieuDatPhongByMaKH(String maKH);
    public List<PhieuDatPhong> getPhieuDatPhongByMaNV(String maNV);
    public List<PhieuDatPhong> getPhieuDatPhongByTinhTrang(int tinhTrang);
    public List<PhieuDatPhong> getPhieuDatPhongByMaPhong(String maPhongId);
}

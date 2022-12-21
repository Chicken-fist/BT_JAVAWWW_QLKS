/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.dao;

import java.util.Date;
import java.util.List;

import com.iuh.entity.Phong;


/**
 *
 * @author DangNguyen
 */
public interface PhongDAO {
	
	public List<Phong> getPhongs();
	public List<Phong> getPhongsKhongQuanTamTinhTrang(String maLoai);
    public Phong getPhong(String phongId);
    public void savePhong(Phong phong);
    public void updatePhong(Phong phong);
    public void deletePhong(String phongId);
    public List<Phong> getPhongByMaLoaiPhong(String maLoai);
    public List<Phong> getPhongByTinhTrang(int tinhTrang);
    public List<Phong> getDSPhongTheoNgay();
    public List<Phong> getPhongByMaPhong(String maPhong);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;

import com.se.entity.Phong;

public interface PhongSerivce {
	public List<Phong> getPhongs();
    public Phong getPhong(String phongId);
    public void savePhong(Phong phong);
    public void updatePhong(Phong phong);
    public void deletePhong(String phongId);
    public List<Phong> getPhongsKhongQuanTamTinhTrang(String maLoai);
    public List<Phong> getPhongByMaLoaiPhong(String maLoai);
    public List<Phong> getPhongByTinhTrang(int tinhTrang);
    public void setPhuongThucPhongMoiNgay();
    public List<Phong> getPhongByMaPhong(String maPhong);
}

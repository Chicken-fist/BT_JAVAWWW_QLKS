/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.dao;

import java.util.List;

import com.iuh.entity.NhanVien;

/**
 *
 * @author DangNguyen
 */
public interface NhanVienDAO {
	public List<NhanVien> getNhanViens();
    public NhanVien getNhanVien(String nhanVienId);
    public void saveNhanVien(NhanVien nhanVien);
    public void updateNhanVien(NhanVien nhanVien);
    public void deleteNhanVien(String nhanVienId);
}

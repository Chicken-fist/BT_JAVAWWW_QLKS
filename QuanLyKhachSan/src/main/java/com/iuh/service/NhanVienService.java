package com.iuh.service;

import java.util.List;

import com.iuh.entity.NhanVien;

public interface NhanVienService {

	public List<NhanVien> getNhanViens();
    public NhanVien getNhanVien(String nhanVienId);
    public void saveNhanVien(NhanVien nhanVien);
    public void updateNhanVien(NhanVien nhanVien);
    public void deleteNhanVien(String nhanVienId);
}

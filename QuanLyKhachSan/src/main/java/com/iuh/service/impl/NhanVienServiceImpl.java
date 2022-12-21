package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.NhanVienDAO;
import com.iuh.entity.NhanVien;
import com.iuh.service.NhanVienService;

@Service
public class NhanVienServiceImpl implements NhanVienService {

	@Autowired
	private NhanVienDAO nhanvienDao;

	@Override
	public List<NhanVien> getNhanViens() {
		return nhanvienDao.getNhanViens();
	}

	@Override
	public NhanVien getNhanVien(String nhanVienId) {
		return nhanvienDao.getNhanVien(nhanVienId);
	}

	@Override
	public void saveNhanVien(NhanVien nhanVien) {
		nhanvienDao.saveNhanVien(nhanVien);

	}

	@Override
	public void updateNhanVien(NhanVien nhanVien) {
		nhanvienDao.updateNhanVien(nhanVien);
	}

	@Override
	public void deleteNhanVien(String nhanVienId) {
		nhanvienDao.deleteNhanVien(nhanVienId);
	}

}

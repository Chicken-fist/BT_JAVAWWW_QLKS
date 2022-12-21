package com.iuh.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.PhongDAO;
import com.iuh.entity.Phong;
import com.iuh.service.PhongSerivce;

@Service
public class PhongServiceImpl implements PhongSerivce {
	@Autowired
	private PhongDAO phongDAO;

	@Override
	public List<Phong> getPhongs() {
		return phongDAO.getPhongs();
	}

	@Override
	public Phong getPhong(String phongId) {
		return phongDAO.getPhong(phongId);
	}

	@Override
	public void savePhong(Phong phong) {
		phongDAO.savePhong(phong);
	}

	@Override
	public void updatePhong(Phong phong) {
		phongDAO.updatePhong(phong);
	}

	@Override
	public void deletePhong(String phongId) {
		phongDAO.deletePhong(phongId);
	}

	public List<Phong> getPhongByMaLoaiPhong(String maLoai) {
		return phongDAO.getPhongByMaLoaiPhong(maLoai);
	}

	@Override
	public List<Phong> getPhongByTinhTrang(int tinhTrang) {
		return phongDAO.getPhongByTinhTrang(tinhTrang);
	}

	@Override
	public List<Phong> getPhongsKhongQuanTamTinhTrang(String maLoai) {
		// TODO Auto-generated method stub
		return phongDAO.getPhongsKhongQuanTamTinhTrang(maLoai);
	}

	@Override
	public List<Phong> getDSPhongTheoNgay() {
		// TODO Auto-generated method stub
		return phongDAO.getDSPhongTheoNgay();
	}

	@Override
	public List<Phong> getPhongByMaPhong(String maPhong) {
		// TODO Auto-generated method stub
		return phongDAO.getPhongByMaPhong(maPhong);
	}
}

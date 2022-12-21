package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.KhachHangDAO;
import com.iuh.entity.KhachHang;
import com.iuh.service.KhachHangService;

@Service
public class KhachHangServiceImpl implements KhachHangService {

	@Autowired
	private KhachHangDAO khachHangDAO;

	@Override
	public List<KhachHang> getKhachHangs() {
		return khachHangDAO.getKhachHangs();
	}

	@Override
	public KhachHang getKhachHang(String khachHangId) {
		return khachHangDAO.getKhachHang(khachHangId);
	}

	@Override
	public void saveKhachHang(KhachHang khachHang) {
		khachHangDAO.saveKhachHang(khachHang);
	}

	@Override
	public void updateKhachHang(KhachHang khachHang) {
		khachHangDAO.updateKhachHang(khachHang);
	}

	@Override
	public void deleteKhachHang(String khachHangId) {
		khachHangDAO.deleteKhachHang(khachHangId);
	}

}

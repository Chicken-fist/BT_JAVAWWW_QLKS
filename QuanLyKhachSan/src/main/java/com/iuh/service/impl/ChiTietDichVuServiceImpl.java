package com.iuh.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.ChiTietDichVuDAO;
import com.iuh.entity.ChiTietDV;
import com.iuh.service.ChiTietDichVuService;

@Service
public class ChiTietDichVuServiceImpl implements ChiTietDichVuService {

	@Autowired
	private ChiTietDichVuDAO chiTietDichVuDAO;

	@Override
	public ChiTietDV getChiTietDV(String maPhieuDatPhong, String MaDV) {
		return chiTietDichVuDAO.getChiTietDV(maPhieuDatPhong, MaDV);
	}

	@Override
	public void saveCTDV(ChiTietDV ctp) {
		chiTietDichVuDAO.saveCTDV(ctp);
	}

	@Override
	public void updateCTDV(ChiTietDV cthd, String maPhieuDatPhong, String MaDV) {
		chiTietDichVuDAO.updateCTDV(cthd, maPhieuDatPhong, MaDV);
	}

	@Override
	public void deleteCTDV(String maPhieuDatPhong, String MaDV) {
		chiTietDichVuDAO.deleteCTDV(maPhieuDatPhong, MaDV);
	}

}

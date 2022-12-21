package com.iuh.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.ChiTietPhongDAO;
import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.entity.Phong;
import com.iuh.service.ChiTietPhongService;
import com.iuh.service.PhieuDatPhongService;
import com.iuh.service.PhongSerivce;

@Service
public class ChiTietPhongServiceImpl implements ChiTietPhongService {

	@Autowired
	private ChiTietPhongDAO chiTietPhongDAO;
	
	@Autowired 
	private PhieuDatPhongService phieuDatPhongService;
	
	@Autowired
	private PhongSerivce phongSerivce;

	@Override
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong) {
		return chiTietPhongDAO.getChiTietPhong(maPhieuDatPhong, maPhong);
	}

	@Override
	public void saveCTP(ChiTietPhong ctp) {
		
		ctp.setPhieuDatPhong(phieuDatPhongService.getPhieuDatPhongs().get(0));
		chiTietPhongDAO.saveCTP(ctp);
		ctp.getPhong().setTinhTrang(4);
		phongSerivce.updatePhong(ctp.getPhong());
	}

	@Override
	public void updateCTP(ChiTietPhong ctdv, String maPhieuDatPhong, String maPhong) {
		chiTietPhongDAO.updateCTP(ctdv, maPhieuDatPhong, maPhong);
	}

	@Override
	public void deleteCTP(String maPhieuDatPhong, String maPhong) {
		chiTietPhongDAO.deleteCTP(maPhieuDatPhong, maPhong);
	}

	@Override
	public PhieuDatPhong getChiTietPhongTheoMaPhong(String maPhong) {
		return chiTietPhongDAO.getChiTietPhongTheoMaPhong(maPhong);
	}
	

}

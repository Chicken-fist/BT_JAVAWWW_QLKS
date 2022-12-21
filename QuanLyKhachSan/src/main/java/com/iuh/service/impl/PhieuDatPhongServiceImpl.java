package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.ChiTietDichVuDAO;
import com.iuh.dao.ChiTietPhongDAO;
import com.iuh.dao.PhieuDatPhongDAO;
import com.iuh.entity.ChiTietDV;
import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.service.PhieuDatPhongService;

@Service
public class PhieuDatPhongServiceImpl implements PhieuDatPhongService {

	@Autowired
	private PhieuDatPhongDAO phieuDatPhongDAO;

	@Autowired
	private ChiTietPhongDAO chiTietPhongDAO;

	@Autowired
	private ChiTietDichVuDAO ctDVDao;

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongs() {
		return phieuDatPhongDAO.getPhieuDatPhongs();
	}

	@Override
	public PhieuDatPhong getPhieuDatPhong(String phieuDatPhongId) {
		return phieuDatPhongDAO.getPhieuDatPhong(phieuDatPhongId);
	}

	@Override
	public void savePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		phieuDatPhongDAO.savePhieuDatPhong(phieuDatPhong);
//		PhieuDatPhong p = getPhieuDatPhongs().get(0);
//		for (ChiTietPhong ctp : phieuDatPhong.getDsPhong()) {
//			ctp.setPhieuDatPhong(phieuDatPhong);
//			chiTietPhongDAO.saveCTP(ctp);
//		}
//		if(phieuDatPhong.getDsCTDV().size() > 0) {
//			for (ChiTietDV ctdv : phieuDatPhong.getDsCTDV()) {
//				ctdv.setPhieuDatPhong(phieuDatPhong);
//				ctDVDao.saveCTDV(ctdv);
//			}
//		}
	}

	@Override
	public void updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		phieuDatPhongDAO.updatePhieuDatPhong(phieuDatPhong);
	}

	@Override
	public void deletePhieuDatPhong(String phieuDatPhongId) {
		phieuDatPhongDAO.deletePhieuDatPhong(phieuDatPhongId);
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByMaKH(String maKH) {
		// TODO Auto-generated method stub
		return phieuDatPhongDAO.getPhieuDatPhongByMaKH(maKH);
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByMaNV(String maNV) {
		return phieuDatPhongDAO.getPhieuDatPhongByMaNV(maNV);
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByTinhTrang(int tinhTrang) {
		return phieuDatPhongDAO.getPhieuDatPhongByTinhTrang(tinhTrang);
	}

	@Override
	public List<PhieuDatPhong> getPhieuDatPhongByMaPhong(String maPhongId) {
		// TODO Auto-generated method stub
		return phieuDatPhongDAO.getPhieuDatPhongByMaPhong(maPhongId);
	}

}

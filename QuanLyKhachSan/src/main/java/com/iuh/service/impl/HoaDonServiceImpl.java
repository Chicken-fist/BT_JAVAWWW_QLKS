package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.HoaDonDAO;
import com.iuh.entity.HoaDon;
import com.iuh.service.HoaDonService;

@Service
public class HoaDonServiceImpl implements HoaDonService {

	@Autowired
	private HoaDonDAO hoaDonDAO;

	@Override
	public List<HoaDon> getHoaDons() {
		return hoaDonDAO.getHoaDons();
	}

	@Override
	public HoaDon getHoaDon(String hoaDonId) {
		return hoaDonDAO.getHoaDon(hoaDonId);
	}

	@Override
	public void saveHoaDon(HoaDon hoaDon) {
		hoaDonDAO.saveHoaDon(hoaDon);
	}

	@Override
	public void updateHoaDon(HoaDon hoaDon) {
		hoaDonDAO.updateHoaDon(hoaDon);
	}

	@Override
	public void deleteHoaDon(String hoaDonId) {
		hoaDonDAO.deleteHoaDon(hoaDonId);
	}

}

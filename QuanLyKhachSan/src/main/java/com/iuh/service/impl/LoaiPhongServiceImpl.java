package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.LoaiPhongDAO;
import com.iuh.entity.LoaiPhong;
import com.iuh.service.LoaiPhongService;

@Service
public class LoaiPhongServiceImpl implements LoaiPhongService {
	@Autowired
	private LoaiPhongDAO loaiPhongDAO;

	@Override
	public List<LoaiPhong> getLoaiPhongs() {
		return loaiPhongDAO.getLoaiPhongs();
	}

	@Override
	public LoaiPhong getLoaiPhong(String loaiPhongId) {
		return loaiPhongDAO.getLoaiPhong(loaiPhongId);
	}

	@Override
	public void saveLoaiPhong(LoaiPhong loaiPhong) {
		loaiPhongDAO.saveLoaiPhong(loaiPhong);
	}

	@Override
	public void updateLoaiPhong(LoaiPhong loaiPhong) {
		loaiPhongDAO.updateLoaiPhong(loaiPhong);
	}

	@Override
	public void deleteLoaiPhong(String loaiPhongId) {
		loaiPhongDAO.deleteLoaiPhong(loaiPhongId);
	}


}

package com.iuh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iuh.dao.DichVuDAO;
import com.iuh.entity.DichVu;
import com.iuh.service.DichVuService;

@Service
public class DichVuServiceImpl implements DichVuService {

	@Autowired
	private DichVuDAO dichVuDAO;

	@Override
	public List<DichVu> getDichVus() {
		return dichVuDAO.getDichVus();
	}

	@Override
	public DichVu getDichVu(String dichVuId) {
		return dichVuDAO.getDichVu(dichVuId);
	}

	@Override
	public void saveDichVu(DichVu dichVu) {
		dichVuDAO.saveDichVu(dichVu);
	}

	@Override
	public void updateDichVu(DichVu dichVu) {
		dichVuDAO.updateDichVu(dichVu);
	}

	@Override
	public void deleteDichVu(String dichVuId) {
		dichVuDAO.deleteDichVu(dichVuId);
	}

}

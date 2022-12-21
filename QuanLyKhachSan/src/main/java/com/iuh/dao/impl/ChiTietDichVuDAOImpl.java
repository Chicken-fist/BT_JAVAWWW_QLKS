package com.iuh.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.dao.ChiTietDichVuDAO;
import com.iuh.entity.ChiTietDV;

@Repository
public class ChiTietDichVuDAOImpl implements ChiTietDichVuDAO{

	@Autowired
	private SessionFactory sessionFactory;




	@Override
	public ChiTietDV getChiTietDV(String maPhieuDatPhong, String MaDV) {
		Session currentSession = sessionFactory.getCurrentSession();
		ChiTietDV ctdv = currentSession.get(ChiTietDV.class, maPhieuDatPhong);
		return ctdv;
	}

	@Override
	@Transactional
	public void saveCTDV(ChiTietDV ctdv) {
		Session currentSession = sessionFactory.getCurrentSession();
//		PhieuDatPhong phieuDatPhong = currentSession.get(PhieuDatPhong.class, maPhieuDatPhong);
//		phieuDatPhong.addCTDicVu(ctdv);	
		currentSession.saveOrUpdate(ctdv);
	}
	@Override
	@Transactional
	public void updateCTDV(ChiTietDV ctdv, String maPhieuDatPhong, String maDV) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		PhieuDatPhong phieuDatPhong = currentSession.get(PhieuDatPhong.class, maPhieuDatPhong);
//		ChiTietDV theCTDV = phieuDatPhong.getCTDV(maPhieuDatPhong, maDV);
//		setValueCTDV(theCTDV, ctdv);
//		currentSession.saveOrUpdate(theCTDV);
	}

	@Override
	@Transactional
	public void deleteCTDV(String maPhieuDatPhong, String maDV) {
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
//		ChiTietDV tempCTDV = currentSession.get(ChiTietDV.class, maPhieuDatPhong);
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("delete from ChiTietDV where maPhieuDatPhong := maPhieu and maDV := maDV1");
		theQuery.setParameter("maPhieu", maPhieuDatPhong);
		theQuery.setParameter("maDV1", maDV);
		
		
		theQuery.executeUpdate();
	}

}

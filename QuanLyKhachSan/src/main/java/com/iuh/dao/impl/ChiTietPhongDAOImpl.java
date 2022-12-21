package com.iuh.dao.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iuh.dao.ChiTietPhongDAO;
import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;

@Repository
public class ChiTietPhongDAOImpl implements ChiTietPhongDAO{

	@Autowired
	private SessionFactory sessionFactory;
	

//	private void setValueCTP(ChiTietPhong theCTP, ChiTietPhong tempCTP) {
//		theCTP.setNgayDat(tempCTP.getNgayDat());
//	}

	@Override
	@Transactional
	public ChiTietPhong getChiTietPhong(String maPhieuDatPhong, String maPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		org.hibernate.query.Query<ChiTietPhong> theQ = currentSession.createQuery("from ChiTietPhong where MaPhieuDat = ?1 and "
				+ "MaPhong = ?2", ChiTietPhong.class);
		theQ.setParameter(1, maPhieuDatPhong);
		theQ.setParameter(2, maPhong);
		
		ChiTietPhong ctp = theQ.getSingleResult();
		return ctp;
	}

	@Override
	@Transactional
	public void saveCTP(ChiTietPhong ctp) {
		Session currentSession = sessionFactory.getCurrentSession();
//		System.out.println( "Ylolo"+ ctp);
		currentSession.saveOrUpdate(ctp);
		
	}

	@Override
	@Transactional
	public void updateCTP(ChiTietPhong cthd, String maPhieuDatPhong, String maPhong) {
//		Session currentSession = sessionFactory.getCurrentSession();
//		PhieuDatPhong phieuDatPhong = currentSession.get(PhieuDatPhong.class, maPhieuDatPhong);
//		ChiTietPhong theCTHD = phieuDatPhong.getCTPhong(maPhieuDatPhong, maPhong);
//		setValueCTP(theCTHD, cthd);?
//		currentSession.saveOrUpdate(theCTHD);
		
	}

	@Override
	@Transactional
	public void deleteCTP(String maPhieuDatPhong, String maPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		// delete object with primary key
		ChiTietPhong tempCTP = currentSession.get(ChiTietPhong.class, maPhieuDatPhong);
		currentSession.delete(tempCTP);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public PhieuDatPhong getChiTietPhongTheoMaPhong(String maPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		@SuppressWarnings("rawtypes")
		Query theQuery = currentSession.createQuery("select c.phieuDatPhong from ChiTietPhong c "
				+ "where MaPhong = :ma" 
				+ " order by c.phieuDatPhong desc");
		
		theQuery.setParameter("ma", maPhong);
		
		List<PhieuDatPhong> listMaPhieu = theQuery.list();
		
		return listMaPhieu.get(0);
	}

}

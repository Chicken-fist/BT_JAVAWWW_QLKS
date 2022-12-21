package com.iuh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.dao.LoaiPhongDAO;
import com.iuh.entity.LoaiPhong;

/**
 * 
 * @author Duc Cuong
 *
 */
@Repository
public class LoaiPhongDAOImpl implements LoaiPhongDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<LoaiPhong> getLoaiPhongs() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<LoaiPhong> theQuery = currentSession.createQuery("from LoaiPhong order by MaLoai desc", LoaiPhong.class);
		List<LoaiPhong> listLoaiPhong = theQuery.getResultList();
		for (LoaiPhong loaiPhong : listLoaiPhong) {
			System.out.println(loaiPhong);
		}
		return listLoaiPhong;
	}

	@Override
	@Transactional
	public LoaiPhong getLoaiPhong(String loaiPhongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		LoaiPhong loaiPhong = currentSession.get(LoaiPhong.class, loaiPhongId);
		return loaiPhong;
	}

	@Override
	@Transactional
	public void saveLoaiPhong(LoaiPhong loaiPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		System.out.println("day ne" + loaiPhong);
		if (loaiPhong.getMaLoai().equals("0")) {
			loaiPhong.setMaLoai(setMaForLoaiPhong());
		}
		currentSession.saveOrUpdate(loaiPhong);
	}

	@Override
	@Transactional
	public void updateLoaiPhong(LoaiPhong loaiPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(loaiPhong);
	}

	@Override
	@Transactional
	public void deleteLoaiPhong(String loaiPhongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		LoaiPhong tempLoaiPhong = currentSession.get(LoaiPhong.class, loaiPhongId);
		currentSession.delete(tempLoaiPhong);
	}

	private String setMaForLoaiPhong() {
		
		String maLPTemp = "0";
		if(getLoaiPhongs().size() > 0) {
			LoaiPhong loaiPhong = getLoaiPhongs().get(0);
			maLPTemp = loaiPhong.getMaLoai().substring(2);
		}
		
		Integer maLPSo = Integer.parseInt(maLPTemp) + 1;
		if (maLPSo < 10) {
			return "lp00" + maLPSo;
		} else if (maLPSo >= 10 && maLPSo < 100) {
			return "lp0" + maLPSo;
		}
		return "lp" + maLPSo;
	}

}

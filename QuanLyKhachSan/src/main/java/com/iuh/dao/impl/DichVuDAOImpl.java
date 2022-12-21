package com.iuh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.dao.DichVuDAO;
import com.iuh.entity.DichVu;

/**
 * 
 * @author Duc Cuong
 *
 */
@Repository
public class DichVuDAOImpl implements DichVuDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<DichVu> getDichVus() {
		Session currentSession = sessionFactory.getCurrentSession();

		Query<DichVu> theQuery = currentSession.createQuery("from DichVu order by MaDV desc", DichVu.class);
		List<DichVu> listDichVu = theQuery.getResultList();
		for (DichVu dichVu : listDichVu) {
			System.out.println(dichVu);
		}
		return listDichVu;
	}

	@Override
	@Transactional
	public DichVu getDichVu(String dichVuId) {
		Session currentSession = sessionFactory.getCurrentSession();
		DichVu dichVu = currentSession.get(DichVu.class, dichVuId);
		return dichVu;
	}

	@Override
	@Transactional
	public void saveDichVu(DichVu dichVu) {
		Session currentSession = sessionFactory.getCurrentSession();
		if (dichVu.getMaDV().equals("0")) {
			dichVu.setMaDV(setMaForDichVu());
		}
		currentSession.saveOrUpdate(dichVu);
	}

	@Override
	@Transactional
	public void updateDichVu(DichVu dichVu) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(dichVu);
	}

	@Override
	@Transactional
	public void deleteDichVu(String dichVuId) {
		Session currentSession = sessionFactory.getCurrentSession();
		DichVu tempDichVu = currentSession.get(DichVu.class, dichVuId);
		currentSession.delete(tempDichVu);
	}

	private String setMaForDichVu() {
		String maDVTemp = "0";
		if (getDichVus().size() > 0) {
			DichVu dichVu = getDichVus().get(0);
			maDVTemp = dichVu.getMaDV().substring(2);
		}
		
		Integer maDVSo = Integer.parseInt(maDVTemp) + 1;
		if (maDVSo < 10) {
			return "dv00" + maDVSo;
		} else if (maDVSo >= 10 && maDVSo < 100) {
			return "dv0" + maDVSo;
		}
		return "dv" + maDVSo;
	}

}

package com.iuh.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.dao.HoaDonDAO;
import com.iuh.entity.HoaDon;

/**
 * 
 * @author Duc Cuong
 *
 */
@Repository
public class HoaDonDAOImpl implements HoaDonDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<HoaDon> getHoaDons() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<HoaDon> theQuery = currentSession.createQuery("from HoaDon", HoaDon.class);

		List<HoaDon> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public HoaDon getHoaDon(String hoaDonId) {
		Session currentSession = sessionFactory.getCurrentSession();
		HoaDon hoaDon = currentSession.get(HoaDon.class, hoaDonId);
		return hoaDon;
	}

	@Override
	@Transactional
	public void saveHoaDon(HoaDon hoaDon) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(hoaDon);
	}

	@Override
	@Transactional
	public void updateHoaDon(HoaDon hoaDon) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(hoaDon);
	}

	@Override
	@Transactional
	public void deleteHoaDon(String hoaDonId) {
		Session currentSession = sessionFactory.getCurrentSession();
		HoaDon tempHoaDon = currentSession.get(HoaDon.class, hoaDonId);
		currentSession.delete(tempHoaDon);
	}

}

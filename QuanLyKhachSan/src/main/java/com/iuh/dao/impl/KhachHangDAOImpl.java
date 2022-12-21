/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.dao.impl;

import com.iuh.dao.KhachHangDAO;
import com.iuh.entity.KhachHang;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriHoang
 */
@Repository
public class KhachHangDAOImpl implements KhachHangDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<KhachHang> getKhachHangs() {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query<KhachHang> theQuery = currentSession.createQuery("from KhachHang order by MaKH desc", KhachHang.class);
		List<KhachHang> listKhachHang = theQuery.getResultList();
		for (KhachHang khachHang : listKhachHang) {
			System.out.println(khachHang);
		}
		return listKhachHang;
	}

	@Override
	@Transactional
	public KhachHang getKhachHang(String khachHangId) {
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang khachHang = currentSession.get(KhachHang.class, khachHangId);
		return khachHang;
	}

	@Override
	@Transactional
	public void saveKhachHang(KhachHang khachHang) {
		Session currentSession = sessionFactory.getCurrentSession();
		if (khachHang.getMaKH().equals("0")) {
			khachHang.setMaKH(setMaForKhachHang());
		}
		// save/upate the customer ... finally
		currentSession.saveOrUpdate(khachHang);

	}

	@Override
	@Transactional
	public void updateKhachHang(KhachHang khachHang) {
		Session currentSession = sessionFactory.getCurrentSession();
		// save/upate the customer ... finally
		currentSession.update(khachHang);

	}

	@Override
	@Transactional
	public void deleteKhachHang(String khachHangId) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		KhachHang tempPerson = currentSession.get(KhachHang.class, khachHangId);
		currentSession.delete(tempPerson);

	}

	private String setMaForKhachHang() {
		
		String maKHTemp = "0";
		if(getKhachHangs().size() > 0) {
			KhachHang khachHang = getKhachHangs().get(0);
			 maKHTemp = khachHang.getMaKH().substring(2);
		}
		
		Integer maKHSo = Integer.parseInt(maKHTemp) + 1;
		if (maKHSo < 10) {
			return "kh00" + maKHSo;
		} else if (maKHSo >= 10 && maKHSo < 100) {
			return "kh0" + maKHSo;
		}
		return "kh" + maKHSo;
	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.dao.impl;

import com.iuh.dao.NhanVienDAO;
import com.iuh.entity.NhanVien;

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
public class NhanVienDAOImpl implements NhanVienDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unused")
	@Transactional
    @Override
	public List<NhanVien> getNhanViens() {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
		Query<NhanVien> theQuery = currentSession.createQuery("from NhanVien order by MaNV desc", NhanVien.class);
		List<NhanVien> listNhanVien = theQuery.getResultList();
		for (NhanVien nhanVien : listNhanVien) {
			System.out.println(nhanVien);
		}
		return listNhanVien;
	}

	@Override
	@Transactional
	public NhanVien getNhanVien(String nhanVienId) {
		 // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        NhanVien nhanVien = currentSession.get(NhanVien.class, nhanVienId);
		return nhanVien;
	}

	@Override
	@Transactional
	public void saveNhanVien(NhanVien nhanVien) {
		 // get current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        if(nhanVien.getMaNV().equals("0")) {
        	nhanVien.setMaNV(setMaForNhaVien());
        }
        // save/upate the customer ... finally
        currentSession.saveOrUpdate(nhanVien);
		
	}

	@Override
	@Transactional
	public void updateNhanVien(NhanVien nhanVien) {
      // get current hibernate session
     Session currentSession = sessionFactory.getCurrentSession();
     // save/upate the customer ... finally
     currentSession.update(nhanVien);
		
	}

	@Override
	@Transactional
	public void deleteNhanVien(String nhanVienId) {
		// get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        NhanVien tempPerson = currentSession.get(NhanVien.class, nhanVienId);
        currentSession.delete(tempPerson);
	}
	
	private String setMaForNhaVien() {
		String maNVTemp = "0";
		if(getNhanViens().size() > 0) {
			NhanVien nv = getNhanViens().get(0);
			maNVTemp = nv.getMaNV().substring(2);
		}
		
		Integer maNVSo = Integer.parseInt(maNVTemp) + 1 ;
		if(maNVSo < 10) {
			return "nv00" + maNVSo ;
		}
		else if(maNVSo >= 10 && maNVSo < 100) {
			return "nv0" + maNVSo;
		}
		return "nv"+ maNVSo;
	}

   
}

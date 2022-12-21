package com.iuh.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.QueryHints;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.dao.PhongDAO;
import com.iuh.entity.Phong;

/**
 * 
 * @author Duc Cuong
 *
 */
@Repository
public class PhongDAOImpl implements PhongDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<Phong> getPhongs() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Phong> theQuery = currentSession.createQuery("from Phong order by maPhong desc", Phong.class);

		List<Phong> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public Phong getPhong(String phongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Phong phong = currentSession.get(Phong.class, phongId);
		return phong;
	}

	@Override
	@Transactional
	public void savePhong(Phong phong) {
		Session currentSession = sessionFactory.getCurrentSession();
		if(phong.getMaPhong().equals("0")) {
			phong.setMaPhong(setMaForPhieuDatPhong());
		}
		currentSession.saveOrUpdate(phong);
	}

	@Override
	@Transactional
	public void updatePhong(Phong phong) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(phong);
	}

	@Override
	@Transactional
	public void deletePhong(String phongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Phong tempPhong = currentSession.get(Phong.class, phongId);
		currentSession.delete(tempPhong);
	}
	
	@Override
	@Transactional
	public List<Phong> getPhongByMaLoaiPhong(String maLoai) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Phong> theQuerry = currentSession.createQuery("from Phong where loaiPhong.maLoai= ?1", Phong.class);
		theQuerry.setParameter(1, maLoai);
		
		List<Phong> phongs = theQuerry.getResultList();
		
		return phongs;
	}
	
	private String setMaForPhieuDatPhong() {
		String maPhongTemp = "0";
		if(getPhongs().size() > 0) {
			Phong p = getPhongs().get(0);
			maPhongTemp = p.getMaPhong().substring(1);
		}
		
		Integer maPhongSo = Integer.parseInt(maPhongTemp) + 1 ;
		
		if(maPhongSo < 10) {
			return "p000" + maPhongSo ;
		}
		else if(maPhongSo >= 10 && maPhongSo < 100) {
			return "p00" + maPhongSo;
		}
		else if(maPhongSo >= 100 && maPhongSo < 1000) {
			return "p0"+maPhongSo;
		}
		return "p" + maPhongSo;
	}

	@Override
	@Transactional
	public List<Phong> getPhongByTinhTrang(int tinhTrang) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Phong> theQuerry = currentSession.createQuery("from Phong where tinhTrang= ?1 ", Phong.class);
		theQuerry.setParameter(1, tinhTrang);
		
		List<Phong> phongs = theQuerry.getResultList();
		
		return phongs;
	}

	@Override
	@Transactional
	public List<Phong> getPhongsKhongQuanTamTinhTrang(String maLoai) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Phong> theQuerry = currentSession.createQuery("from Phong where maLoai= ?1", Phong.class);
		theQuerry.setParameter(1, maLoai);
		
		List<Phong> phongs = theQuerry.getResultList();
		
		return phongs;
	} 
	
	@Override
	@Transactional
	public List<Phong> getDSPhongTheoNgay() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuerry = currentSession.createQuery("select p.maPhong "
				+ "from Phong p, ChiTietPhong c , "
				+ "PhieuDatPhong o "
				+ "where p.tinhTrang = 4 and ngayNhanPhong <= GETDATE() and  ngayTraPhong  >= GETDATE() "
				+ "group by p.maPhong");
		List<Phong> phongs = theQuerry.list();
//		List<Phong> phong = new ArrayList<Phong>();
		
		
		
		return phongs;
	} 
	
	@Override
	@Transactional
	public List<Phong> getPhongByMaPhong(String maPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Phong> theQuerry = currentSession.createQuery("from Phong where maPhong = :maPhong1", Phong.class);
		
		theQuerry.setParameter("maPhong1", maPhong);
		
		List<Phong> phongs = theQuerry.list();
		
		return phongs;
	}

}

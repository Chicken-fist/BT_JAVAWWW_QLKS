package com.iuh.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iuh.dao.PhieuDatPhongDAO;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.entity.Phong;

/**
 * 
 * @author Duc Cuong
 *
 */
@Repository
public class PhieuDatPhongDAOImpl implements PhieuDatPhongDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public List<PhieuDatPhong> getPhieuDatPhongs() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PhieuDatPhong> theQuery = currentSession.createQuery("from PhieuDatPhong order by MaPhieuDatPhong desc", PhieuDatPhong.class);

		List<PhieuDatPhong> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public PhieuDatPhong getPhieuDatPhong(String phieuDatPhongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		PhieuDatPhong phieuDatPhong = currentSession.get(PhieuDatPhong.class, phieuDatPhongId);
		return phieuDatPhong;
	}

	@Override
	@Transactional
	public void savePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		if(phieuDatPhong.getMaPhieuDatPhong().equals("0")) {
			phieuDatPhong.setMaPhieuDatPhong(setMaForPhieuDatPhong());
		}
		currentSession.saveOrUpdate(phieuDatPhong);
	}

	@Override
	@Transactional
	public void updatePhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(phieuDatPhong);
	}

	@Override
	@Transactional
	public void deletePhieuDatPhong(String phieuDatPhongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		PhieuDatPhong tempPhieuDatPhong = currentSession.get(PhieuDatPhong.class, phieuDatPhongId);
		currentSession.delete(tempPhieuDatPhong);
	}

	@Override
	@Transactional
	public List<PhieuDatPhong> getPhieuDatPhongByMaKH(String maKH) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PhieuDatPhong> theQuery = currentSession.createQuery("from PhieuDatPhong where maKH = ?1", PhieuDatPhong.class);
		theQuery.setParameter(1, maKH);
		
		List<PhieuDatPhong> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<PhieuDatPhong> getPhieuDatPhongByMaNV(String maNV) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PhieuDatPhong> theQuery = currentSession.createQuery("from PhieuDatPhong where MaNV = ?1", PhieuDatPhong.class);
		theQuery.setParameter(1, maNV);
		
		List<PhieuDatPhong> list = theQuery.getResultList();
		return list;
	}
	
	

	private String setMaForPhieuDatPhong() {
		
		PhieuDatPhong phieu = null;
		if(getPhieuDatPhongs().size() > 0) {
			phieu = getPhieuDatPhongs().get(0);
		}
		Integer maPhieuSo = 1;
		if(phieu != null) {
			maPhieuSo = Integer.parseInt(phieu.getMaPhieuDatPhong()) + 1 ;
		}
		
		if(maPhieuSo < 10) {
			return "000" + maPhieuSo ;
		}
		else if(maPhieuSo >= 10 && maPhieuSo < 100) {
			return "00" + maPhieuSo;
		}
		else if(maPhieuSo >= 100 && maPhieuSo < 1000) {
			return "0"+maPhieuSo;
		}
		return "" + maPhieuSo;
	}

	@Override
	@Transactional
	public List<PhieuDatPhong> getPhieuDatPhongByTinhTrang(int tinhTrang) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Query<PhieuDatPhong> theQuery = currentSession.createQuery("from PhieuDatPhong where TinhTrang = ?1", PhieuDatPhong.class);
		theQuery.setParameter(1, tinhTrang);
		
		List<PhieuDatPhong> list = theQuery.getResultList();
		return list;
	}

	@Override
	@Transactional
	public List<PhieuDatPhong> getPhieuDatPhongByMaPhong(String maPhongId) {
		Session currentSession = sessionFactory.getCurrentSession();
		SQLQuery theQuery = currentSession.createSQLQuery("SELECT p.maPhieuDatPhong "
				+ "from PhieuDatPhong p join ChiTietPhong c on p.MaPhieuDatPhong = c.MaPhieuDat "
				+ "where c.MaPhong = '"+maPhongId+"' and NgayTraPhong > GETDATE()");
		theQuery.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<String> phieuDats = theQuery.list();
		List<PhieuDatPhong> phieuDat = new ArrayList<PhieuDatPhong>();
		for (String phieuDatPhong : phieuDats) {
			System.out.println(getPhieuDatPhong(phieuDatPhong));
			phieuDat.add(getPhieuDatPhong(phieuDatPhong));
		}
		
		return phieuDat;
	} 
	
	
}

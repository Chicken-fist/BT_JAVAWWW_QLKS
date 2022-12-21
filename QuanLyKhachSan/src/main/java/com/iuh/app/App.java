package com.iuh.app;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;

import com.iuh.entity.ChiTietDV;
import com.iuh.entity.ChiTietDV_PK;
import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.ChiTietPhong_PK;
import com.iuh.entity.DichVu;
import com.iuh.entity.HoaDon;
import com.iuh.entity.KhachHang;
import com.iuh.entity.LoaiPhong;
import com.iuh.entity.NhanVien;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.entity.Phong;

public class App {
	public static void main(String[] args) {
		ServiceRegistry standardRegistry = new StandardServiceRegistryBuilder().configure().build();

		Metadata metadata = new MetadataSources(standardRegistry)
			.addAnnotatedClass(LoaiPhong.class)
			.addAnnotatedClass(Phong.class)
			.addAnnotatedClass(ChiTietPhong_PK.class)			
			.addAnnotatedClass(ChiTietPhong.class)			
			.addAnnotatedClass(PhieuDatPhong.class)
			.addAnnotatedClass(NhanVien.class)
			.addAnnotatedClass(KhachHang.class)
			.addAnnotatedClass(HoaDon.class)			
			.addAnnotatedClass(DichVu.class)
			.addAnnotatedClass(ChiTietDV_PK.class)	
			.addAnnotatedClass(ChiTietDV.class)	
				.getMetadataBuilder().build();

		SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

		
		Session session = sessionFactory.getCurrentSession();

		Transaction transaction = session.getTransaction();

		try {
			transaction.begin();

			transaction.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			transaction.rollback();
		}
//		HoaDon hoaDon = new HoaDon("PDP01", new Date(2020, 2, 1), 20, 10, 10);
		
	}
}

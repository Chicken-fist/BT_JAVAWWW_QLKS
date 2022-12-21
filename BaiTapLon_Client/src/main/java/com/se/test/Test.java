//package com.se.test;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//
//import com.se.entity.ChiTietDV;
//import com.se.entity.ChiTietPhong;
//import com.se.entity.DichVu;
//import com.se.entity.HoaDon;
//import com.se.entity.KhachHang;
//import com.se.entity.LoaiPhong;
//import com.se.entity.NhanVien;
//import com.se.entity.PhieuDatPhong;
//import com.se.entity.Phong;
//
//public class Test {
//	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
////		NhanVien nv01 = new NhanVien("NV01", null, null, null, null, null, null, null);
////		KhachHang kh01 = new KhachHang("KH01", null, null, null, null, null);
////		DichVu dv01 = new DichVu("DV01", null, 10, 0);
////		LoaiPhong loaiPhong01 = new LoaiPhong("LP01", null, null, 100, 0, 0, null);
////		Phong phong01 = new Phong("P01", 0, null, loaiPhong01);
////		
////		PhieuDatPhong phieuDatPhong01 = new PhieuDatPhong("PDP01", new Date(2020, 1, 1),
////				 new Date(2020, 1, 1), 0, 0, 0, kh01, nv01);
////		
////		ChiTietDV ctDV01 = new ChiTietDV(1, dv01);
////		System.out.println("ctdv: "+ ctDV01.getThanhTien());
////		
//////		ChiTietPhong chiTietPhong01 = new ChiTietPhong(phong01, null);
////		phieuDatPhong01.addChiTietDV(2, dv01);
////		phieuDatPhong01.addCTPhong(phong01, null);
////		
////		
////		HoaDon hoaDon = new HoaDon("HD01", null, 8, phieuDatPhong01);
////		System.out.println(hoaDon.getTongTien());
////		System.out.println("Phu thu : " +hoaDon.getPhuThu());
////		System.out.println(hoaDon.getTienDV());
////		System.out.println(hoaDon.getTienPhong());
////		for (int i = 0; i < 5; i++) {
////			if(i==2) {				
////				continue;
////			}
////			System.out.println(i);
////			
////		}
//		
//		
//		Date ngayNhan = new Date();
//		Date ngayTra = null;
//		Calendar c = Calendar.getInstance();
//		
//		
//		try {
//			 ngayTra = new SimpleDateFormat("yyyy-MM-dd").parse("2022-05-19");
//			 c.setTime(ngayTra);
//			 c.add(Calendar.DATE, 1);  // number of days to add
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		if(ngayNhan.after(ngayTra.setTime(c.getTimeInMillis()))) {
//			System.out.println("xxxxx");
//		}
//	}
//}

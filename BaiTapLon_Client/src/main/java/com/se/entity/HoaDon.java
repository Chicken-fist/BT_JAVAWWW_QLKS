package com.se.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class HoaDon {
	private String maHD;
	private Date ngayLap;
	private int soNguoiLonThucTe;
	private double phuThu;
	private double tienPhong;
	private double tienDV;
	
	private double tongTien;
	
	private PhieuDatPhong phieuDatPhong;

	
	public double getTienPhong() {
		double rs = 0;
		long soNgay = (phieuDatPhong.getNgayTraPhong().getTime() - phieuDatPhong.getNgayNhanPhong().getTime())/ (24 * 3600 * 1000);
		if(soNgay<1)
			soNgay=1;
		for (ChiTietPhong ctPhong : phieuDatPhong.getDsChiTietPhong()) {
			rs += ctPhong.getPhong().getLoaiPhong().getDonGia()*soNgay;
		}
		return rs;
	}
	public double getTienDV() {
		double rs = 0;
		for (ChiTietDV chiTietDV : phieuDatPhong.getDsCTDV()) {
			rs += chiTietDV.getThanhTien();
		}
		return rs ;
	}
	public PhieuDatPhong getPhieuDatPhong() {
		return phieuDatPhong;
	}
	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public double getTongTien() {
		return tongTien;
	}
	
	public int getSoNguoiLonThucTe() {
		return soNguoiLonThucTe;
	}

	public void setSoNguoiLonThucTe(int soNguoiLonThucTe) {
		this.soNguoiLonThucTe = soNguoiLonThucTe;
	}

	public HoaDon(String maHD, Date ngayLap,int soNguoiLonThucTe, PhieuDatPhong phieuDatPhong) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.phieuDatPhong = phieuDatPhong;
		this.soNguoiLonThucTe = soNguoiLonThucTe;
		int soNGuoiToiDa = phieuDatPhong.getDsChiTietPhong().size()*7;
		int soNguoiPhuTHu = soNguoiLonThucTe - soNGuoiToiDa;
		Set<ChiTietPhong> listCTPhong = phieuDatPhong.getDsChiTietPhong();
		for (ChiTietPhong chiTietPhong : listCTPhong ) {
			if(soNguoiPhuTHu > 0) {
				phuThu += soNguoiPhuTHu * 100000;
			}
		}
		this.tongTien = phieuDatPhong.getTongTien() + phuThu;
	}
	public double getPhuThu() {
		return phuThu;
	}
	
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", tongTien=" + tongTien + "]";
	}
	public HoaDon(String maHD) {
		super();
		this.maHD = maHD;
	}
	
	
}

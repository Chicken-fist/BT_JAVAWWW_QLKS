package com.iuh.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class HoaDon {
	
	@Id
	@Column(name="MaHD")
	private String maHD;
	@Column(name="NgayLap")
	private Date ngayLap;
	@Column(name="TongTien")
	private double tongTien;
	@Column(name="TienPhong")
	private double tienPhong;
	@Column(name = "TienDV")
	private double tienDV;
	@Column(name = "SoNguoiLonThucTe")
	private int soNguoiLonThucTe;
	@Column(name = "PhuThu")
	private double phuThu;
	//relationship
	
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "MaHD")
	private PhieuDatPhong phieuDatPhong;
	
	
	public HoaDon() {
		// TODO Auto-generated constructor stub
	}


	public HoaDon(String maHD, Date ngayLap, double tongTien, double tienPhong, double tienDV) {
		super();
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.tongTien = tongTien;
		this.tienPhong = tienPhong;
		this.tienDV = tienDV;
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


	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}


	public double getTienPhong() {
		double rs = 0;
		long soNgay = (phieuDatPhong.getNgayTraPhong().getTime() - phieuDatPhong.getNgayNhanPhong().getTime())/ (24 * 3600 * 1000);
		if(soNgay<1)
			soNgay=1;
		for (ChiTietPhong ctPhong : phieuDatPhong.getDsPhong()	) {
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


//	public PhieuDatPhong getPhieuDatPhong() {
//		return phieuDatPhong;
//	}
//
//
//	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
//		this.phieuDatPhong = phieuDatPhong;
//	}
	
	public HoaDon(String maHD, Date ngayLap,int soNguoiLonThucTe, PhieuDatPhong phieuDatPhong) {
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.phieuDatPhong = phieuDatPhong;
		this.soNguoiLonThucTe = soNguoiLonThucTe;
		int soNGuoiToiDa = phieuDatPhong.getDsPhong().size()*7;
		int soNguoiPhuTHu = soNguoiLonThucTe - soNGuoiToiDa;
		Set<ChiTietPhong> listCTPhong = phieuDatPhong.getDsPhong();
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
	
	
}

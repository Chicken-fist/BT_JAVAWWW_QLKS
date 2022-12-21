package com.se.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


public class PhieuDatPhong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5165274329935726563L;
	private String maPhieuDatPhong;
//	@NotNull(message = "is required")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date ngayNhanPhong;
//	@NotNull(message = "is required")
//	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date ngayTraPhong;
	@Min(value=0, message = "Tối thiểu 1")
	@Max(value=10000, message = "must be less than or equal to ten")
	private int soNguoiLon;
	@Min(value=0, message = "Tối thiểu 1")
	@Max(value=10000, message = "must be less than or equal to ten")
	private int soTreEm;
	private int tinhTrangPhieuDat;
	private double tongTien = 0.0;
	
	private KhachHang khachHang;
	private NhanVien nhanVien;
	// relashionship
	private Set<ChiTietDV> dsCTDV;
	private Set<ChiTietPhong> dsChiTietPhong;
	
	public String getMaPhieuDatPhong() {
		return maPhieuDatPhong;
	}

	public void setMaPhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}

	public Date getNgayNhanPhong() {
		return ngayNhanPhong;
	}

	public void setNgayNhanPhong(Date ngayNhanPhong) {
		this.ngayNhanPhong = ngayNhanPhong;
	}


	public Date getNgayTraPhong() {
		return ngayTraPhong;
	}

	public void setNgayTraPhong(Date ngayTraPhong) {
		this.ngayTraPhong = ngayTraPhong;
	}

	public int getSoNguoiLon() {
		return soNguoiLon;
	}

	public void setSoNguoiLon(int soNguoiLon) {
		this.soNguoiLon = soNguoiLon;
	}

	public int getSoTreEm() {
		return soTreEm;
	}

	public void setSoTreEm(int soTreEm) {
		this.soTreEm = soTreEm;
	}

	public int getTinhTrangPhieuDat() {
		return tinhTrangPhieuDat;
	}

	public void setTinhTrangPhieuDat(int tinhTrangPhieuDat) {
		this.tinhTrangPhieuDat = tinhTrangPhieuDat;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public double getTongTien() {
		return this.tongTien ;
	}

	public PhieuDatPhong() {
		super();
		this.dsChiTietPhong = new HashSet<ChiTietPhong>();
		this.dsCTDV = new HashSet<ChiTietDV>();
	}
	
	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Set<ChiTietDV> getDsCTDV() {
		return dsCTDV;
	}

	public void setDsCTDV(Set<ChiTietDV> dsCTDV) {
		this.dsCTDV = dsCTDV;
	}

	public Set<ChiTietPhong> getDsChiTietPhong() {
		return dsChiTietPhong;
	}

	public void setDsChiTietPhong(Set<ChiTietPhong> dsChiTietPhong) {
		this.dsChiTietPhong = dsChiTietPhong;
	}

	public PhieuDatPhong(String maPhieuDatPhong, Date ngayNhanPhong, Date ngayTraPhong, int soNguoiLon,
			int soTreEm, int tinhTrangPhieuDat, KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.tinhTrangPhieuDat = tinhTrangPhieuDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.dsChiTietPhong = new HashSet<ChiTietPhong>();
		this.dsCTDV = new HashSet<ChiTietDV>();
		this.tongTien = 0.0;
	}
	public void addChiTietDV(int soLanSuDung, DichVu dichVu) {
		ChiTietDV chiTietDV = new ChiTietDV(soLanSuDung, dichVu);
		this.dsCTDV.add(chiTietDV);
		this.tongTien += chiTietDV.getThanhTien();
	}
	public void removeChiTietDV(int soLanSuDung, DichVu dichVu) {
		ChiTietDV chiTietDV = new ChiTietDV(soLanSuDung, dichVu);
		this.dsCTDV.remove(chiTietDV);
		this.tongTien -= chiTietDV.getThanhTien();
	}
	
	public void addCTPhong(Phong phong, Date ngayDat) {
		ChiTietPhong chiTietPhong = new ChiTietPhong(phong, ngayDat);
		dsChiTietPhong.add(chiTietPhong);
		long soNgay = (ngayTraPhong.getTime() - ngayNhanPhong.getTime())/ (24 * 3600 * 1000);
		if(soNgay < 1)
			soNgay = 1;
		this.tongTien += chiTietPhong.getPhong().getLoaiPhong().getDonGia() * soNgay;
		System.out.println("ngay: " + soNgay);
	}
	public void removeCTPhong(Phong phong, Date ngayDat) {
		ChiTietPhong chiTietPhong = new ChiTietPhong(phong, ngayDat);
		dsChiTietPhong.remove(chiTietPhong);
		long soNgay = (ngayTraPhong.getTime() - ngayTraPhong.getTime())/ (24 * 3600 * 1000);
		if(soNgay < 1)
			soNgay = 1;
		this.tongTien -= chiTietPhong.getPhong().getLoaiPhong().getDonGia() * soNgay;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", ngayNhanPhong=" + ngayNhanPhong
				+ ", ngayTraPhong=" + ngayTraPhong + ", soNguoiLon=" + soNguoiLon + ", soTreEm=" + soTreEm
				+ ", tinhTrangPhieuDat=" + tinhTrangPhieuDat + ", tongTien=" + tongTien + ", khachHang=" + khachHang
				+ ", nhanVien=" + nhanVien + ", dsCTDV=" + dsCTDV + ", dsChiTietPhong=" + dsChiTietPhong + "]";
	}

	public PhieuDatPhong(String maPhieuDatPhong) {
		super();
		this.maPhieuDatPhong = maPhieuDatPhong;
	}
	
	
	
}

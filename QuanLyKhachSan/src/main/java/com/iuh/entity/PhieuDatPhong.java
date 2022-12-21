package com.iuh.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;


@Entity
public class PhieuDatPhong {
	
	@Id
	@Column(name="MaPhieuDatPhong")
	private String maPhieuDatPhong;
	@Column(name = "NgayNhanPhong", columnDefinition = "DATE")
	private Date ngayNhanPhong;
	@Column(name = "NgayTraPhong", columnDefinition = "DATE")
	private Date ngayTraPhong;
	@Column(name = "TinhTrangPhieuDat")
	private int tinhTrangPhieuDat;
	@Column(name = "SoNguoiLon")
	private int soNguoiLon;
	@Column(name = "SoTreEm")
	private int soTreEm;
	
	
	// relationship
	@ManyToOne
	@JoinColumn(name = "MaKH")
	private KhachHang khachHang;
	
	@ManyToOne
	@JoinColumn(name="MaNV")
	private NhanVien nhanVien;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "phieuDatPhong")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<ChiTietDV> dsCTDV;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "phieuDatPhong")
	@Fetch(value = FetchMode.SUBSELECT)
	private Set<ChiTietPhong> dsPhong;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private HoaDon hoaDon;
	
	@Column(name = "TongTien")
	private double tongTien;
	
	
	
	public PhieuDatPhong(String maPhieuDatPhong) {
		this.maPhieuDatPhong = maPhieuDatPhong;
	}

	public double getTongTien() {
		return tongTien;
	}

	public PhieuDatPhong() {
		this.dsPhong = new HashSet<ChiTietPhong>();
		this.dsCTDV = new HashSet<ChiTietDV>();
	}


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


	public int getTinhTrangPhieuDat() {
		return tinhTrangPhieuDat;
	}


	public void setTinhTrangPhieuDat(int tinhTrangPhieuDat) {
		this.tinhTrangPhieuDat = tinhTrangPhieuDat;
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


	public KhachHang getKhachHang() {
		return khachHang;
	}


	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
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


	public Set<ChiTietPhong> getDsPhong() {
		return dsPhong;
	}


//	public void setDsPhong(Set<ChiTietPhong> dsPhong) {
//		this.dsPhong = dsPhong;
//	}


	public HoaDon getHoaDon() {
		return hoaDon;
	}


	public void setHoaDon(HoaDon hoaDon) {
		this.hoaDon = hoaDon;
	}


	public PhieuDatPhong(String maPhieuDatPhong, Date ngayNhanPhong, Date ngayTraPhong, int soNguoiLon,
			int soTreEm, int tinhTrangPhieuDat, KhachHang khachHang, NhanVien nhanVien) {
		this.maPhieuDatPhong = maPhieuDatPhong;
		this.ngayTraPhong = ngayTraPhong;
		this.soNguoiLon = soNguoiLon;
		this.soTreEm = soTreEm;
		this.tinhTrangPhieuDat = tinhTrangPhieuDat;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
		this.dsPhong = new HashSet<ChiTietPhong>();
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
		dsPhong.add(chiTietPhong);
		long soNgay = (ngayTraPhong.getTime() - ngayNhanPhong.getTime())/ (24 * 3600 * 1000);
		if(soNgay < 1)
			soNgay = 1;
		this.tongTien += chiTietPhong.getPhong().getLoaiPhong().getDonGia() * soNgay;
	}
	public void removeCTPhong(Phong phong, Date ngayDat) {
		ChiTietPhong chiTietPhong = new ChiTietPhong(phong, ngayDat);
		dsPhong.remove(chiTietPhong);
		long soNgay = (ngayTraPhong.getTime() - ngayTraPhong.getTime())/ (24 * 3600 * 1000);
		if(soNgay < 1)
			soNgay = 1;
		this.tongTien -= chiTietPhong.getPhong().getLoaiPhong().getDonGia() * soNgay;
	}

	@Override
	public String toString() {
		return "PhieuDatPhong [maPhieuDatPhong=" + maPhieuDatPhong + ", ngayNhanPhong=" + ngayNhanPhong
				+ ", ngayTraPhong=" + ngayTraPhong + ", tinhTrangPhieuDat=" + tinhTrangPhieuDat + ", soNguoiLon="
				+ soNguoiLon + ", soTreEm=" + soTreEm + ", khachHang=" + khachHang + ", nhanVien=" + nhanVien
				+ ", dsCTDV=" + dsCTDV + ", tongTien=" + tongTien + "]";
	}

	
	
	
	
}

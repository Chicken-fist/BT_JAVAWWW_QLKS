	package com.iuh.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class NhanVien {
	@Id
	@Column(name="MaNV")
	private String maNV;
	@Column(name="TenNV", columnDefinition = "nvarchar(50)")
	private String tenNV;
	@Column(name="NgayThue")
	private Date ngayThue;
	@Column(name="NgaySinh")
	private Date ngaySinh;
	@Column(name="CMND", columnDefinition = "nvarchar(50)")
	private String cmnd;
	@Column(name="SoDienThoai", columnDefinition = "nvarchar(50)")
	private String soDienThoai;
	@Column(name="DiaChi", columnDefinition = "nvarchar(50)")
	private String diaChi;
	@Column(name="TinhTrang", columnDefinition = "nvarchar(50)")
	private int tinhTrang;
	// relationship
	
//	@OneToMany(mappedBy = "nhanVien")
//	private List<PhieuDatPhong> dsPhieuDatPhong;
	
	
	
	public NhanVien() {
		// TODO Auto-generated constructor stub
	}



	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}



	public NhanVien(String maNV, String tenNV, Date ngayThue, Date ngaySinh, String cmnd, String soDienThoai,
			String diaChi, int tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngayThue = ngayThue;
		this.ngaySinh = ngaySinh;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.tinhTrang = tinhTrang;
	}



	public String getMaNV() {
		return maNV;
	}



	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}



	public String getTenNV() {
		return tenNV;
	}



	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}



	public Date getNgayThue() {
		return ngayThue;
	}



	public void setNgayThue(Date ngayThue) {
		this.ngayThue = ngayThue;
	}



	public Date getNgaySinh() {
		return ngaySinh;
	}



	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}



	public String getCmnd() {
		return cmnd;
	}



	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}



	public String getSoDienThoai() {
		return soDienThoai;
	}



	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}



	public String getDiaChi() {
		return diaChi;
	}



	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}



	public int getTinhTrang() {
		return tinhTrang;
	}



	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}



////	public List<PhieuDatPhong> getDsPhieuDatPhong() {
////		return dsPhieuDatPhong;
////	}
////
////
////
////	public void setDsPhieuDatPhong(List<PhieuDatPhong> dsPhieuDatPhong) {
////		this.dsPhieuDatPhong = dsPhieuDatPhong;
//	}
	
}

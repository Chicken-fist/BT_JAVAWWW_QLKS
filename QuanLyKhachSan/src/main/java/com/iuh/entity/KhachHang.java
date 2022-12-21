package com.iuh.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class KhachHang {
	@Id
	@Column(name="MaKH")
	private String maKH;
	@Column(name="TenKH", columnDefinition = "nvarchar(50)")
	private String tenKH;
	@Column(name="CMND", columnDefinition = "nvarchar(50)")
	private String cmnd;
	@Column(name="SoDienThoai", columnDefinition = "nvarchar(50)")
	private String soDienThoai;
	@Column(name="Email", columnDefinition = "nvarchar(50)")
	private String email;
	@Column(name="DiaChi", columnDefinition = "nvarchar(50)")
	private String diaChi;
	
	
	// relationship
//	@OneToMany(mappedBy = "khachHang")
//	private List<PhieuDatPhong> dsPhieuDP;

	
	public KhachHang() {
		// TODO Auto-generated constructor stub
	}


	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}


	public String getMaKH() {
		return maKH;
	}


	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}


	public String getTenKH() {
		return tenKH;
	}


	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


//	public List<PhieuDatPhong> getDsPhieuDP() {
//		return dsPhieuDP;
//	}
//
//
//	public void setDsPhieuDP(List<PhieuDatPhong> dsPhieuDP) {
//		this.dsPhieuDP = dsPhieuDP;
//	}


	public KhachHang(String maKH, String tenKH, String cmnd, String soDienThoai, String email, String diaChi) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}
	
}

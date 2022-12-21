package com.se.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class KhachHang implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maKH;
	@NotNull(message = "is required Client")
	@Size(min=1,message = "is required Client")
	private String tenKH;
	@NotNull(message = "is required")
	@Pattern(regexp = "^[0-9]{12}", message = "only 12 digits")
	private String cmnd;
	@NotNull(message = "is required")
	@Pattern(regexp = "^[0-9]{10}", message = "only 10 digits")
	private String soDienThoai;
	@NotNull(message = "is required")
	@Pattern(regexp = "^[A-Za-z0-9]{1}[A-Za-z0-9.]{2,12}[A-Za-z0-9]{1}@[A-Za-z]{3,6}.com", message = "dun dinh dang dum ngta 1 cai")
	private String email;
	@NotNull(message = "is required Client")
	@Size(min=1,message = "is required Client")
	private String diaChi;
	
	private List<PhieuDatPhong> dsPhieuDatPhong;
	
	public KhachHang(String maKH, String tenKH, String cmnd, String soDienThoai, String email, String diaChi) {
		super();
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.email = email;
		this.diaChi = diaChi;
	}
	public KhachHang() {
		super();
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
	@Override
	public String toString() {
		return "KhachHang [maKH=" + maKH + ", tenKH=" + tenKH + ", cmnd=" + cmnd + ", soDienThoai=" + soDienThoai
				+ ", email=" + email + ", diaChi=" + diaChi + "]";
	}
	
	public PhieuDatPhong getPhieuDatPhong(String maPhieuDatPhong) {
		if(dsPhieuDatPhong !=null) {
			for (PhieuDatPhong phieuDatPhong : dsPhieuDatPhong) {
				if(phieuDatPhong.getMaPhieuDatPhong() == maPhieuDatPhong)
					return phieuDatPhong;
			}
		}
		return null;
	}
	public void addPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		if(dsPhieuDatPhong == null) {
			dsPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		}
		dsPhieuDatPhong.add(phieuDatPhong);
	}
	public KhachHang(String maKH) {
		super();
		this.maKH = maKH;
	}
	
}

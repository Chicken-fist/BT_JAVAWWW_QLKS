package com.se.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NhanVien implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String maNV;
	private String tenNV;
	private String ngayThue;
	private String ngaySinh;
	private String cmnd;
	private String soDienThoai;
	private String diaCHi;
	private String tinhTrang;
	
	private List<PhieuDatPhong> dsPhieuDatPhong;
	
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
	public String getNgayThue() {
		return ngayThue;
	}
	public void setNgayThue(String ngayThue) {
		this.ngayThue = ngayThue;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
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
	public String getDiaCHi() {
		return diaCHi;
	}
	public void setDiaCHi(String diaCHi) {
		this.diaCHi = diaCHi;
	}
	public String getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public List<PhieuDatPhong> getDsPhieuDatPhong() {
		return dsPhieuDatPhong;
	}
	public void setDsPhieuDatPhong(List<PhieuDatPhong> dsPhieuDatPhong) {
		this.dsPhieuDatPhong = dsPhieuDatPhong;
	}
	public NhanVien(String maNV, String tenNV, String ngayThue, String ngaySinh, String cmnd, String soDienThoai,
			String diaCHi, String tinhTrang) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.ngayThue = ngayThue;
		this.ngaySinh = ngaySinh;
		this.cmnd = cmnd;
		this.soDienThoai = soDienThoai;
		this.diaCHi = diaCHi;
		this.tinhTrang = tinhTrang;
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", tenNV=" + tenNV + ", ngayThue=" + ngayThue + ", ngaySinh=" + ngaySinh
				+ ", cmnd=" + cmnd + ", soDienThoai=" + soDienThoai + ", diaCHi=" + diaCHi + ", tinhTrang=" + tinhTrang
				+ "]";
	}
	public NhanVien() {
		super();
	}
	public void addHoaDon(PhieuDatPhong phieuDatPhong) {
		if(dsPhieuDatPhong == null) {
			dsPhieuDatPhong = new ArrayList<PhieuDatPhong>();
		}
		dsPhieuDatPhong.add(phieuDatPhong);
	}
	public PhieuDatPhong getHoaDon(String maPDP) {
		if(dsPhieuDatPhong != null) {
			for (PhieuDatPhong phieuDatPhong : dsPhieuDatPhong) {
				if(phieuDatPhong.getMaPhieuDatPhong() == maPDP)
					return phieuDatPhong;
			}
		}
		return null;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	
}

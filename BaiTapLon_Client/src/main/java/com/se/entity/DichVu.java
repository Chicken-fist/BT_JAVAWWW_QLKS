package com.se.entity;

public class DichVu {
	private String maDV;
	private String tenDV;
	private double donGia;
	private int tinhTrang;
	public String getMaDV() {
		return maDV;
	}
	public void setMaDV(String maDV) {
		this.maDV = maDV;
	}
	public String getTenDV() {
		return tenDV;
	}
	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public DichVu(String maDV, String tenDV, double donGia, int tinhTrang) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.donGia = donGia;
		this.tinhTrang = tinhTrang;
	}
	public DichVu() {
		super();
	}
	@Override
	public String toString() {
		return "DichVu [maDV=" + maDV + ", tenDV=" + tenDV + ", donGia=" + donGia + ", tinhTrang=" + tinhTrang + "]";
	}
	public DichVu(String maDV) {
		super();
		this.maDV = maDV;
	}
	
}

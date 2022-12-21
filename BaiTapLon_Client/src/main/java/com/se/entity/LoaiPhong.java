package com.se.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoaiPhong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7739870852380532479L;
	private String maLoai;
	private String tenLoai;
	private String moTa;
	private double donGia;
	private int soGiuongNgu;
	private double dienTich;
	private byte[] hinhAnh;
	
	private List<Phong> dsPhong;
	public String getMaLoai() {
		return maLoai;
	}
	public void setMaLoai(String maLoai) {
		this.maLoai = maLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public int getSoGiuongNgu() {
		return soGiuongNgu;
	}
	public void setSoGiuongNgu(int soGiuongNgu) {
		this.soGiuongNgu = soGiuongNgu;
	}
	public double getDienTich() {
		return dienTich;
	}
	public void setDienTich(double dienTich) {
		this.dienTich = dienTich;
	}
	public byte[] getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(byte[] hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	
	public List<Phong> getListPhong() {
		return dsPhong;
	}
	public void setListPhong(List<Phong> dsPhong) {
		this.dsPhong = dsPhong;
	}
	public LoaiPhong(String maLoai, String tenLoai, String moTa, double donGia, int soGiuongNgu, double dienTich,
			byte[] hinhAnh) {
		super();
		this.maLoai = maLoai;
		this.tenLoai = tenLoai;
		this.moTa = moTa;
		this.donGia = donGia;
		this.soGiuongNgu = soGiuongNgu;
		this.dienTich = dienTich;
		this.hinhAnh = hinhAnh;
	}
	public LoaiPhong() {
		super();
	}
	// loaiphong: co 1 ds phong -> 
	// add Phong
	// lay1 phong cua 1 loaiphong
	public void addPhong(Phong phong) {
		if(dsPhong == null) {
			dsPhong = new ArrayList<Phong>();
		}
		dsPhong.add(phong);
	}
	public Phong get1PhongCua1LoaiPhong(String maPhong) {
		if(dsPhong != null) {
			for (Phong phong : dsPhong) {
				if(phong.getMaPhong().equals(maPhong))
					return phong;
			}
		}
		return null;
	}
	@Override
	public String toString() {
		return "LoaiPhong [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", moTa=" + moTa + ", donGia=" + donGia
				+ ", soGiuongNgu=" + soGiuongNgu + ", dienTich=" + dienTich + ", hinhAnh=" + Arrays.toString(hinhAnh)
				+ ", listPhong=" + dsPhong + "]";
	}
	public LoaiPhong(String maLoai) {
		super();
		this.maLoai = maLoai;
	}
	
}

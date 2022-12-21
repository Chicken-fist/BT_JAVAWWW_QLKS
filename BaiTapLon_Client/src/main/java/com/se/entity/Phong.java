package com.se.entity;

import java.io.Serializable;

public class Phong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2973587028895855149L;
	private String maPhong;
	private int tinhTrang;
	private String moTa;
	
	private LoaiPhong loaiPhong;

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}
	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	
	public Phong(String maPhong, int tinhTrang, String moTa, LoaiPhong loaiPhong) {
		super();
		this.maPhong = maPhong;
		this.tinhTrang = tinhTrang;
		this.moTa = moTa;
		this.loaiPhong = loaiPhong;
	}
	public Phong() {
		super();
	}
	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}
	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tinhTrang=" + tinhTrang + ", moTa=" + moTa + ", loaiPhong=" + loaiPhong
				+ "]";
	}
	
}

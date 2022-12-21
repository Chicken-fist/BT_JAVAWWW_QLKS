package com.se.entity;

public class ChiTietDV {
	private int soLanSuDung;
	private double thanhTien;
	private DichVu dichVu;
	
	public int getSoLanSuDung() {
		return soLanSuDung;
	}
	public void setSoLanSuDung(int soLanSuDung) {
		this.soLanSuDung = soLanSuDung;
	}
	public DichVu getDichVu() {
		return dichVu;
	}
	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
	public double getThanhTien() {
		return thanhTien;
	}
	public ChiTietDV(int soLanSuDung, DichVu dichVu) {
		super();
		this.soLanSuDung = soLanSuDung;
		this.dichVu = dichVu;
		this.thanhTien = soLanSuDung*dichVu.getDonGia();
	}
	public ChiTietDV() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietDV [soLanSuDung=" + soLanSuDung + ", thanhTien=" + thanhTien + ", dichVu=" + dichVu + "]";
	}
	
	
}

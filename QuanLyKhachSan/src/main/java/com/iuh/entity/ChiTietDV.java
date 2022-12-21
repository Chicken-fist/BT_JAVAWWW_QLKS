package com.iuh.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@IdClass(ChiTietDV_PK.class)
@Table(name = "ChiTietDV")
public class ChiTietDV implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "MaDV")
	private DichVu dichVu;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MaPhieuDatPhong")
	private PhieuDatPhong phieuDatPhong;
	
	@Column(name="SoLanSuDung")
	private int soLanSuDung;
	
//	@Column(name="ThanhTien"
	private double thanhTien;
	
	public ChiTietDV() {
		// TODO Auto-generated constructor stub
	}

	public DichVu getDichVu() {
		return dichVu;
	}

	public void setDichVu(DichVu dichVu) {
		this.dichVu = dichVu;
	}
//
//	public PhieuDatPhong getPhieuDatPhong() {
//		return phieuDatPhong;
//	}

	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}

	public int getSoLanSuDung() {
		return soLanSuDung;
	}

	public void setSoLanSuDung(int soLanSuDung) {
		this.soLanSuDung = soLanSuDung;
	}

	public double getThanhTien() {
		return thanhTien;
	}


	public ChiTietDV(DichVu dichVu, PhieuDatPhong phieuDatPhong, int soLanSuDung) {
		super();
		this.dichVu = dichVu;
		this.phieuDatPhong = phieuDatPhong;
		this.soLanSuDung = soLanSuDung;
		this.thanhTien = soLanSuDung*dichVu.getDonGia();
	}

	public ChiTietDV( int soLanSuDung, DichVu dichVu) {
		this.dichVu = dichVu;
		this.soLanSuDung = soLanSuDung;
		this.thanhTien = soLanSuDung*dichVu.getDonGia();
	}


	
	
}

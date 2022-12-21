package com.se.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ChiTietPhong implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private PhieuDatPhong phieuDatPhong;
	
	private Phong phong;
	
	private Date ngayDat;
	
	public Phong getPhong() {
		return phong;
	}

	public void setPhong(Phong phong) {
		this.phong = phong;
	}

	public Date getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(Date ngayDat) {
		this.ngayDat = ngayDat;
	}


	public ChiTietPhong() {
	}

//	public PhieuDatPhong getPhieuDatPhong() {
//		return phieuDatPhong;
//	}

	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}

	public ChiTietPhong(Phong phong, Date ngayDat) {
		this.phong = phong;
		this.ngayDat = ngayDat;
	}

	@Override
	public String toString() {
		return "ChiTietPhong [phong=" + phong + ", ngayDat=" + ngayDat ;
	}

		
}

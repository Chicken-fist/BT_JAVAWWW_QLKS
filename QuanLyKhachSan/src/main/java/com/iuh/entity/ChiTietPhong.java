package com.iuh.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.AnnotationIntrospector.ReferenceProperty.Type;


@Entity
@IdClass(ChiTietPhong_PK.class)
public class ChiTietPhong implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne()
	@JoinColumn(name = "MaPhieuDat")
	private PhieuDatPhong phieuDatPhong;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "MaPhong")
	private Phong phong;
	
	@Column(name="NgayDat", columnDefinition = "Date")
	private Date ngayDat;
	
	public ChiTietPhong() {
		// TODO Auto-generated constructor stub
	}

	public ChiTietPhong(Phong phong, Date ngayDat) {
		this.phong = phong;
		this.ngayDat = ngayDat;
	}

//	public PhieuDatPhong getPhieuDatPhong() {
//		return phieuDatPhong;
//	}

	public void setPhieuDatPhong(PhieuDatPhong phieuDatPhong) {
		this.phieuDatPhong = phieuDatPhong;
	}

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

	@Override
	public String toString() {
		return "ChiTietPhong [phong=" + phong + ", ngayDat=" + ngayDat +"]";
	}
	
	
}

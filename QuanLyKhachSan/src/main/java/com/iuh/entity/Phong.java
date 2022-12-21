package com.iuh.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
//@Table(name = "Phong")
public class Phong {
	
	@Id
	@Column(name="MaPhong")
	private String maPhong;
	@Column(name = "TinhTrang")
	private int tinhTrang;
	@Column(name="MoTa", columnDefinition = "nvarchar(50)")
	private String moTa;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="MaLoai")
	private LoaiPhong loaiPhong;
	
	@OneToMany(mappedBy = "phong")
	private List<ChiTietPhong> dsCTPhong;
	
	public Phong() {
		// TODO Auto-generated constructor stub
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

	public LoaiPhong getLoaiPhong() {
		return loaiPhong;
	}

	public void setLoaiPhong(LoaiPhong loaiPhong) {
		this.loaiPhong = loaiPhong;
	}

	@Override
	public String toString() {
		return "Phong [maPhong=" + maPhong + ", tinhTrang=" + tinhTrang + ", moTa=" + moTa + ", loaiPhong=" + loaiPhong
				+ "]";
	}

	public Phong(String maPhong) {
		super();
		this.maPhong = maPhong;
	}

//	public List<ChiTietPhong> getDsCTPhong() {
//		return dsCTPhong;
//	}
//
//	public void setDsCTPhong(List<ChiTietPhong> dsCTPhong) {
//		this.dsCTPhong = dsCTPhong;
//	}

	
	
	
	
}

package com.iuh.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class DichVu {
	@Id
	@Column(name = "MaDV")
	private String maDV;
	@Column(name = "TenDV", columnDefinition = "nvarchar(50)")
	private String tenDV;
	@Column(name = "DonGia")
	private double donGia;
	@Column(name = "TinhTrang")
	private int tinhTrang;
	
//	@OneToMany(mappedBy = "dichVu")
//	private List<ChiTietDV> dsCTDV;
	
	public DichVu() {
		// TODO Auto-generated constructor stub
	}

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

//	public List<ChiTietDV> getDsCTDV() {
//		return dsCTDV;
//	}
//
//	public void setDsCTDV(List<ChiTietDV> dsCTDV) {
//		this.dsCTDV = dsCTDV;
//	}
	
	
}

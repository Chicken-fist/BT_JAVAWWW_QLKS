package com.iuh.entity;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LoaiPhong")
public class LoaiPhong {
	@Id
	@Column(name = "MaLoai")
	private String maLoai;
	@Column(name = "TenLoai", columnDefinition = "nvarchar(50)")
	private String tenLoai;
	@Column(name = "MoTa",columnDefinition = "nvarchar(50)")
	private String moTa;
	@Column(name = "DonGia")
	private double donGia;
	@Column(name = "SoGiuongNgu")
	private int soGiuongNgu;
	@Column(name = "DienTich")
	private double dienTich;
	@Column(name="HinhAnh",columnDefinition = "image")
	private byte[] hinhAnh;
	
	// relationship
//	@OneToMany(fetch = FetchType.EAGER)
//	@JoinColumn(name = "MaLoai")
//	private List<Phong> dsPhong;
	
	public LoaiPhong() {
		// TODO Auto-generated constructor stub
	}

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

//	public List<Phong> getDsPhong() {
//		return dsPhong;
//	}
//
//	public void setDsPhong(List<Phong> dsPhong) {
//		this.dsPhong = dsPhong;
//	}

	@Override
	public String toString() {
		return "LoaiPhong [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", moTa=" + moTa + ", donGia=" + donGia
				+ ", soGiuongNgu=" + soGiuongNgu + ", dienTich=" + dienTich + ", hinhAnh=" + Arrays.toString(hinhAnh)
				+ "]";
	}

	public LoaiPhong(String maLoai) {
		super();
		this.maLoai = maLoai;
	}
	
//	public Phong getPhong(String maPhong) {
//		if(dsPhong != null) {
//			for (Phong phong : dsPhong) {
//				if(phong.getMaPhong() == maPhong) {
//					return phong;
//				}
//			}
//		}
//		
//		return null;
//	}

	
	
	
}

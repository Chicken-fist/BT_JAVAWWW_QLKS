package com.iuh.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietPhong_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String phieuDatPhong;
	private String phong;
	
	public ChiTietPhong_PK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((phieuDatPhong == null) ? 0 : phieuDatPhong.hashCode());
		result = prime * result + ((phong == null) ? 0 : phong.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietPhong_PK other = (ChiTietPhong_PK) obj;
		if (phieuDatPhong == null) {
			if (other.phieuDatPhong != null)
				return false;
		} else if (!phieuDatPhong.equals(other.phieuDatPhong))
			return false;
		if (phong == null) {
			if (other.phong != null)
				return false;
		} else if (!phong.equals(other.phong))
			return false;
		return true;
	}
	
}

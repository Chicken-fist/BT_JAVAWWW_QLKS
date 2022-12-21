package com.iuh.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ChiTietDV_PK implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dichVu;
	private String phieuDatPhong;
	
	public ChiTietDV_PK() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dichVu == null) ? 0 : dichVu.hashCode());
		result = prime * result + ((phieuDatPhong == null) ? 0 : phieuDatPhong.hashCode());
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
		ChiTietDV_PK other = (ChiTietDV_PK) obj;
		if (dichVu == null) {
			if (other.dichVu != null)
				return false;
		} else if (!dichVu.equals(other.dichVu))
			return false;
		if (phieuDatPhong == null) {
			if (other.phieuDatPhong != null)
				return false;
		} else if (!phieuDatPhong.equals(other.phieuDatPhong))
			return false;
		return true;
	}
	
	
}

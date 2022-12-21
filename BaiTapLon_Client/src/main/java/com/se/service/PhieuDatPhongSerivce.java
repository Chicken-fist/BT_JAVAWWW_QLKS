/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.se.entity.ChiTietPhong;
import com.se.entity.PhieuDatPhong;

public interface PhieuDatPhongSerivce {
	public List<PhieuDatPhong> getPhieuDatPhongs();
    public PhieuDatPhong getPhieuDatPhong(String phieuDatPhongId);
    public PhieuDatPhong savePhieuDatPhong(PhieuDatPhong phieuDatPhong);
    public void updatePhieuDatPhong(PhieuDatPhong phieuDatPhong);
    public void deletePhieuDatPhong(String phieuDatPhongId);
    public List<PhieuDatPhong> getPhieuDatPhongByMaPhong(String maPhongId);
}

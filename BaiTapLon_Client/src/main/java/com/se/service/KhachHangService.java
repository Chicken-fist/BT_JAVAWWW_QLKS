/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;

import com.se.entity.KhachHang;

public interface KhachHangService {
	public List<KhachHang> getKhachHangs();
    public KhachHang getKhachHang(String khachHangId);
    public void saveKhachHang(KhachHang khachHang);
    public void updateKhachHang(KhachHang khachHang);
    public void deleteKhachHang(String khachHangId);
}

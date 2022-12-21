/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;

import com.se.entity.LoaiPhong;

/**
 *
 * @author DangNguyen
 */
public interface LoaiPhongService {
	public List<LoaiPhong> getLoaiPhongs();
    public LoaiPhong getLoaiPhong(String loaiPhongId);
    public void saveLoaiPhong(LoaiPhong loaiPhong);
    public void updateLoaiPhong(LoaiPhong loaiPhong);
    public void deleteLoaiPhong(String loaiPhongId);
}

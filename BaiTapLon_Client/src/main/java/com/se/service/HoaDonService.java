/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.service;

import java.util.List;

import com.se.entity.HoaDon;

public interface HoaDonService {
	public List<HoaDon> getHoaDons();
    public HoaDon getHoaDon(String hoaDonId);
    public void saveHoaDon(HoaDon hoaDon);
    public void updateHoaDon(HoaDon hoaDon);
    public void deleteHoaDon(String hoaDonId);
}

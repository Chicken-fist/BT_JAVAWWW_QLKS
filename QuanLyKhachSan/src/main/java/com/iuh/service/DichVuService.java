/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iuh.service;

import java.util.List;

import com.iuh.entity.DichVu;


/**
 *
 * @author DangNguyen
 */
public interface DichVuService {
	public List<DichVu> getDichVus();
    public DichVu getDichVu(String dichVuId);
    public void saveDichVu(DichVu dichVu);
    public void updateDichVu(DichVu dichVu);
    public void deleteDichVu(String dichVuId);
}

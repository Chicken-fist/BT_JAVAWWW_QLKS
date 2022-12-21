package com.se.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.se.service.PhongSerivce;

@Controller
public class NhanVienController {
	
	@Autowired
	private PhongSerivce phongSerivce;

	@GetMapping("/nhanvien")
	public String getNVHome(Model model) {
		model.addAttribute("rooms", phongSerivce.getPhongs());
		Date ngayDat = null;
		model.addAttribute("ngayHumNay", ngayDat);
		phongSerivce.setPhuongThucPhongMoiNgay();
		return "nhanvien-trangchu";
	}
	
	@GetMapping("/showNhanVien")
	public String showDSNhanVien(Model model) {
//		model.addAttribute("rooms", phongSerivce.getPhongs());
//		Date ngayDat = null;
//		model.addAttribute("ngayHumNay", ngayDat);
		return "hello_Quoc_Dang";
	}
	
}

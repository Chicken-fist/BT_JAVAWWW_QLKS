package com.se.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.LoaiPhong;
import com.se.entity.Phong;
import com.se.service.LoaiPhongService;
import com.se.service.PhongSerivce;

@Controller
@RequestMapping("/category")
public class LoaiPhongController {

	@Autowired
	private LoaiPhongService loaiPhongService;
	@Autowired
	private PhongSerivce phongSerivce;
	
	@GetMapping("/list")
	public String listLoaiPhong(Model model) {
		List<LoaiPhong> customers = loaiPhongService.getLoaiPhongs();
		model.addAttribute("categories", customers);
		return "list-categories";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {
		LoaiPhong customer = new LoaiPhong();
		model.addAttribute("category", customer);
		return "category-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") String categoryId
			,Model model) {
		LoaiPhong customer = loaiPhongService.getLoaiPhong(categoryId);
		model.addAttribute("category", customer);
		return "category-form";
	}
	@PostMapping("/saveCategory")
	public String saveCustomer(@ModelAttribute("category") LoaiPhong loaiPhong) {
//		List<Phong> listPhong = null;
//		if(!loaiPhong.getMaLoai().equals("0"))
//			listPhong = phongSerivce.getPhongByMaLoaiPhong(loaiPhong.getMaLoai());
//		loaiPhong.setListPhong(listPhong);
		loaiPhongService.saveLoaiPhong(loaiPhong);
		return "redirect:/category/list";
	}
	
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("categoryId") String id) {
		loaiPhongService.deleteLoaiPhong(id);
		return "redirect:/category/list";
	}
//	@GetMapping("/search")
}

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
import com.se.service.PhongSerivce;

@Controller
@RequestMapping("/room")
public class PhongController {
	
	@Autowired
	private PhongSerivce phongSerivce;
	
	@GetMapping("/list")
	private String listRooms(Model model,@RequestParam("categoryId") String categoryId) {
		List<Phong> list = phongSerivce.getPhongsKhongQuanTamTinhTrang(categoryId);
		model.addAttribute("rooms", list);
		model.addAttribute("categoryId", categoryId);
		System.out.println(categoryId);
		return "list-rooms";
	}
	
	@PostMapping("/saveRoom")
	public String saveRoom(@ModelAttribute("room") Phong phong,
			@RequestParam("categoryId") String categoryId) {
		phong.setLoaiPhong(new LoaiPhong(categoryId));
		phongSerivce.savePhong(phong);
		return "redirect:/room/list?categoryId=" + categoryId;
	}
	@PostMapping("/updateRoom")
	public String updateRoom(@ModelAttribute("room") Phong phong,
			@RequestParam("categoryId") String categoryId) {
		phongSerivce.updatePhong(phong);
		return "redirect:/room/list?categoryId=" + categoryId;
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(@RequestParam("categoryId") String categoryId,
			Model model) {
		Phong phong = new Phong();
		model.addAttribute("roomAttribute", phong);
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("isUpdate", false);
		return "room-form";
	}
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("categoryId") String categoryId,
			@RequestParam("roomId") String roomId,
			Model model) {
		List<Phong> phong = phongSerivce.getPhongByMaLoaiPhong(categoryId);
		model.addAttribute("roomAttribute", phong.get(0));
		model.addAttribute("categoryId", categoryId);
		model.addAttribute("isUpdate", true);
		return "room-form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("categoryId") String categoryId, @RequestParam("roomId") String roomId) {
		phongSerivce.deletePhong(roomId);
		return "redirect:/room/list?categoryId="+categoryId;
	}
	
}

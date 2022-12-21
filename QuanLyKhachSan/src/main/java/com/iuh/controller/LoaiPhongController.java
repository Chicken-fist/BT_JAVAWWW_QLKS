package com.iuh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.entity.LoaiPhong;
import com.iuh.service.LoaiPhongService;

@RestController
@RequestMapping("/hotel")
public class LoaiPhongController {

	@Autowired
	private LoaiPhongService loaiService;

	@GetMapping("/categories")
	public List<LoaiPhong> getLoaiPhongs() {
		return loaiService.getLoaiPhongs();
	}

	@GetMapping("/categories/{maLoai}")
	public LoaiPhong getLoaiPhong(@PathVariable String maLoai) {
		LoaiPhong loaiPhong = loaiService.getLoaiPhong(maLoai);
		if (loaiPhong == null) {
			throw new RuntimeException("not found");
		}
		return loaiPhong;
	}

	@PostMapping("/categories")
	public LoaiPhong addLoaiPhong(@RequestBody LoaiPhong theLoaiPhong) {
		theLoaiPhong.setMaLoai("0");
		loaiService.saveLoaiPhong(theLoaiPhong);
		return theLoaiPhong;
	}

	@PutMapping("/categories")
	public LoaiPhong updateLoaiPhong(@RequestBody LoaiPhong theLoaiPhong) {
		loaiService.saveLoaiPhong(theLoaiPhong);
		return theLoaiPhong;
	}

	@DeleteMapping("/categories/{maLoai}")
	public String deleteLoaiPhong(@PathVariable String maLoai) {
		LoaiPhong tempLoaiPhong = loaiService.getLoaiPhong(maLoai);
		if (tempLoaiPhong == null) {
			throw new RuntimeException("Loai phong id not found - " + maLoai);
		}
		loaiService.deleteLoaiPhong(maLoai);
		return "Delete customer id - " + maLoai;
	}

}

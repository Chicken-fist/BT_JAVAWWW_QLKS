package com.iuh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.entity.ChiTietDV;
import com.iuh.service.ChiTietDichVuService;

@RestController
@RequestMapping("/hotel")
public class ChiTietDichVuController {
	
	@Autowired
	private ChiTietDichVuService chiTietDichVuService;
	
	@GetMapping("/servicedetails/{maPhieu}/{maPhong}")
	public ChiTietDV getDichVu(@PathVariable String maPhieu, @PathVariable String maDV) {
		ChiTietDV ctdv = chiTietDichVuService.getChiTietDV(maPhieu, maDV);
		if (ctdv == null) {
			throw new RuntimeException("not found");
		}
		return ctdv;
	}
	
	@PostMapping("/servicedetails")
	public ChiTietDV addCTP(@RequestBody ChiTietDV ctdv) {
		chiTietDichVuService.saveCTDV(ctdv);
		return ctdv;
	}
	
	@DeleteMapping("/servicedetails/{maPhieu}/{maPhong}")
	public String deleteCTDV(@PathVariable String maPhieu, @PathVariable String maDV) {
		if(chiTietDichVuService.getChiTietDV(maPhieu, maDV) != null) {
			chiTietDichVuService.deleteCTDV(maPhieu, maDV);
			return "Da Xoa";
		}
		
		
		return "Not found";
	
	}

}

package com.iuh.controller;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.service.ChiTietPhongService;
import com.iuh.service.PhieuDatPhongService;

@RestController
@RequestMapping("/hotel")
public class ChiTietPhongController {
	
	@Autowired
	private ChiTietPhongService chiTietPhongService;
	
	@Autowired 
	private PhieuDatPhongService phieuDatPhongService;
	
	
//	@GetMapping("/roomdetails")
//	public List<ChiTietPhong> getDichVus() {
//		return chiTietPhongService.get;
//	}
	
	

	@GetMapping("/roomdetails/{maPhieu}/{maPhong}")
	public ChiTietPhong getDichVu(@PathVariable String maPhieu, @PathVariable String maPhong) {
		ChiTietPhong ctp = chiTietPhongService.getChiTietPhong(maPhieu, maPhong);
		if (ctp == null) {
			throw new RuntimeException("not found");
		}
		return ctp;
	}

	@PostMapping("/roomdetails")
	public ChiTietPhong addCTP(@RequestBody ChiTietPhong ctp) {
		chiTietPhongService.saveCTP(ctp);
		return ctp;
	}

	@PutMapping("/roomdetails")
	public ChiTietPhong updateDichVu(@RequestBody ChiTietPhong ctp) {
		ctp.setPhieuDatPhong(phieuDatPhongService.getPhieuDatPhongs().get(0));
		chiTietPhongService.saveCTP(ctp);
		return ctp;
	}

//	@DeleteMapping("/roomdetails/{maDichVu}")
//	public String deleteDichVu(@PathVariable String maDichVu) {
//		DichVu tempDichVu = dichVuService.getDichVu(maDichVu);
//		if (tempDichVu == null) {
//			throw new RuntimeException("Dich vu id not found - " + maDichVu);
//		}
//		dichVuService.deleteDichVu(maDichVu);
//		return "Delete dich vu id - " + maDichVu;
//	}
	
	@GetMapping("/roomdetails/getPhieuDatTheMaPhong/{maPhong}")
	public PhieuDatPhong getDichVuTheMaPhong(@PathVariable String maPhong) {
		
		PhieuDatPhong result = chiTietPhongService.getChiTietPhongTheoMaPhong(maPhong);
		if (result == null) {
			throw new RuntimeException("not found");
		}
		return result;
//		return null;
	}

}

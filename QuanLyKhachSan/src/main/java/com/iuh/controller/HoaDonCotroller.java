package com.iuh.controller;

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

import com.iuh.entity.HoaDon;
import com.iuh.service.HoaDonService;

@RestController
@RequestMapping("/hotel")
public class HoaDonCotroller {

	@Autowired
	private HoaDonService hoaDonService;
	
	@GetMapping("/bills")
	public List<HoaDon> getHoaDons(){
		return hoaDonService.getHoaDons();
	}
	
	@GetMapping("/bills/{maHD}")
	public HoaDon getHoaDonById(@PathVariable String maHD) {
		return hoaDonService.getHoaDon(maHD);
	}
	
	@PostMapping("/bills")
	public HoaDon addHoaDon(@RequestBody HoaDon hd) {
		hd.setMaHD("0");
		hoaDonService.saveHoaDon(hd);
		return hd;
	}
	
	@PutMapping("/bills")
	public HoaDon updateHoaDon(@RequestBody HoaDon hd) {
		hoaDonService.saveHoaDon(hd);
		return hd;
	}
	
	@DeleteMapping("/bills/{maHD}")
	public String deleteHoaDon(@PathVariable String maHD) {
		HoaDon hd = hoaDonService.getHoaDon(maHD);
		if(hd == null) {
			throw new RuntimeException("Khong tim thay ma nay");
		}
		
		hoaDonService.deleteHoaDon(maHD);
		return "da xoa";
	}
}

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

import com.iuh.entity.KhachHang;
import com.iuh.service.KhachHangService;

@RestController
@RequestMapping("/hotel")
public class KhachHangController {

	@Autowired
	private KhachHangService khachHangService;

	@GetMapping("/customers")
	public List<KhachHang> loaiPhongs() {
		return khachHangService.getKhachHangs();
	}

	@GetMapping("/customers/{maKhachHang}")
	public KhachHang getKhachHang(@PathVariable String maKhachHang) {
		KhachHang khachHang = khachHangService.getKhachHang(maKhachHang);
		if (khachHang == null) {
			throw new RuntimeException("not found");
		}
		return khachHang;
	}

	@PostMapping("/customers")
	public KhachHang addCustomer(@RequestBody KhachHang theKhachHang) {
		theKhachHang.setMaKH("0");
		khachHangService.saveKhachHang(theKhachHang);
		return theKhachHang;
	}

	@PutMapping("/customers")
	public KhachHang updateCustomer(@RequestBody KhachHang theKhachHang) {
		khachHangService.saveKhachHang(theKhachHang);
		return theKhachHang;
	}

	@DeleteMapping("/customers/{maKhachHang}")
	public String deleteKhachHang(@PathVariable String maKhachHang) {
		KhachHang tempKhachHang = khachHangService.getKhachHang(maKhachHang);
		if (tempKhachHang == null) {
			throw new RuntimeException("Khach hang id not found - " + maKhachHang);
		}
		khachHangService.deleteKhachHang(maKhachHang);
		return "Delete khach hang id - " + maKhachHang;
	}

}

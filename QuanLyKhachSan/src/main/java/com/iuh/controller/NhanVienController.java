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

import com.iuh.entity.NhanVien;
import com.iuh.service.NhanVienService;

@RestController
@RequestMapping("/hotel")
public class NhanVienController {

	@Autowired
	private NhanVienService nhanVienService;

	@GetMapping("/employees")
	public List<NhanVien> getNhanVien() {
		return nhanVienService.getNhanViens();
	}

	@GetMapping("/employees/{maNhanVien}")
	public NhanVien getNhanVien(@PathVariable String maNhanVien) {
		NhanVien nhanVien = nhanVienService.getNhanVien(maNhanVien);
		if (nhanVien == null) {
			throw new RuntimeException("not found");
		}
		return nhanVien;
	}

	@PostMapping("/employees")
	public NhanVien addNhanVien(@RequestBody NhanVien theNhanVien) {
		theNhanVien.setMaNV("0");
		nhanVienService.saveNhanVien(theNhanVien);
		return theNhanVien;
	}

	@PutMapping("/employees")
	public NhanVien updateNhanVien(@RequestBody NhanVien theNhanVien) {
		nhanVienService.saveNhanVien(theNhanVien);
		return theNhanVien;
	}

	@DeleteMapping("/employees/{maNhanVien}")
	public String deleteNhanVien(@PathVariable String maNhanVien) {
		NhanVien tempNhanVien = nhanVienService.getNhanVien(maNhanVien);
		if (tempNhanVien == null) {
			throw new RuntimeException("Employee id not found - " + maNhanVien);
		}
		nhanVienService.deleteNhanVien(maNhanVien);
		return "Delete employee id - " + maNhanVien;
	}

}

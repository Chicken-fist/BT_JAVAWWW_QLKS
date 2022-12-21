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

import com.iuh.entity.DichVu;
import com.iuh.service.DichVuService;

@RestController
@RequestMapping("/hotel")
public class DichVuController {

	@Autowired
	private DichVuService dichVuService;

	@GetMapping("/services")
	public List<DichVu> getDichVus() {
		return dichVuService.getDichVus();
	}

	@GetMapping("/services/{maDichVu}")
	public DichVu getDichVu(@PathVariable String maDichVu) {
		DichVu dichVu = dichVuService.getDichVu(maDichVu);
		if (dichVu == null) {
			throw new RuntimeException("not found");
		}
		return dichVu;
	}

	@PostMapping("/services")
	public DichVu addDichVu(@RequestBody DichVu theDichVu) {
		theDichVu.setMaDV("0");
		dichVuService.saveDichVu(theDichVu);
		return theDichVu;
	}

	@PutMapping("/services")
	public DichVu updateDichVu(@RequestBody DichVu theDichVu) {
		dichVuService.saveDichVu(theDichVu);
		return theDichVu;
	}

	@DeleteMapping("/services/{maDichVu}")
	public String deleteDichVu(@PathVariable String maDichVu) {
		DichVu tempDichVu = dichVuService.getDichVu(maDichVu);
		if (tempDichVu == null) {
			throw new RuntimeException("Dich vu id not found - " + maDichVu);
		}
		dichVuService.deleteDichVu(maDichVu);
		return "Delete dich vu id - " + maDichVu;
	}

}

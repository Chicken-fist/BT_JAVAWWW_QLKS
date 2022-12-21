package com.iuh.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import com.iuh.entity.Phong;
import com.iuh.service.PhongSerivce;

@RestController
@RequestMapping("/hotel")
public class PhongController {

	@Autowired
	private PhongSerivce phongService;

	@GetMapping("/rooms/getPhongByMaLoai/{maLoai}")
	public List<Phong> getPhongByMaLoai(@PathVariable String maLoai) {
		return phongService.getPhongByMaLoaiPhong(maLoai);
	}

	@GetMapping("/rooms")
	public List<Phong> getPhongs() {
		return phongService.getPhongs();
	}

	// loi cho nay tai vi no bat ham tren chua lay ham duoi
	@GetMapping("/rooms/{maPhong}")
	public Phong getPhong(@PathVariable String maPhong) {
		Phong phong = phongService.getPhong(maPhong);
		if (phong == null) {
			throw new RuntimeException("not found");
		}
		return phong;
	}

	@PostMapping("/rooms")
	public Phong addPhong(@RequestBody Phong thePhong) {
		thePhong.setMaPhong("0");
		phongService.savePhong(thePhong);
		return thePhong;
	}

	@PutMapping("/rooms")
	public Phong updateCustomer(@RequestBody Phong thePhong) {
		phongService.savePhong(thePhong);
		return thePhong;
	}

	@DeleteMapping("/rooms/{maPhong}")
	public String deleteCustomer(@PathVariable String maPhong) {
		Phong tempPhong = phongService.getPhong(maPhong);
		if (tempPhong == null) {
			throw new RuntimeException("Phong id not found - " + maPhong);
		}
		phongService.deletePhong(maPhong);
		return "Delete phong id - " + maPhong;
	}
	
	//Cho nay cung loi ne
	@GetMapping("/rooms/getPhongByTinhTrang/{tinhTrang}")
	public List<Phong> getPhongByTinhTrang(@PathVariable int tinhTrang) {
		return phongService.getPhongByTinhTrang(tinhTrang);
	}
	
	@GetMapping("/rooms/getPhongByMaLoaiKhongQuanTamTT/{maLoai}")
	public List<Phong> getPhongByMaLoaiKhongQuanTamTT(@PathVariable String maLoai) {
		return phongService.getPhongsKhongQuanTamTinhTrang(maLoai);
	}
	
	@GetMapping("/rooms/getPhongTheoNgayNhanNgayTra")
	public List<Phong> getPhongTheoNgayNhanNgayTra( )  {
		return phongService.getDSPhongTheoNgay();
	}
	
	@GetMapping("/rooms/getPhongByMaPhong/{maPhong}")
	public List<Phong> getPhongByMaPhong(@PathVariable String maPhong) {
		return phongService.getPhongByMaPhong(maPhong);
	}

}

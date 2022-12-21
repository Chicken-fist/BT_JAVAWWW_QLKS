package com.iuh.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.iuh.entity.ChiTietPhong;
import com.iuh.entity.PhieuDatPhong;
import com.iuh.entity.Phong;
import com.iuh.service.PhieuDatPhongService;
import com.iuh.service.PhongSerivce;

@RestController
@RequestMapping("/hotel")
public class PhieuDatPhongController {
	
	@Autowired
	private PhieuDatPhongService phieuDatPhongService;
	
	@Autowired
	private PhongSerivce phongService;
	
	
	@GetMapping("/reservations")
	public List<PhieuDatPhong> getPhieuDatPhongs(){
		return phieuDatPhongService.getPhieuDatPhongs();
	}
	
	@GetMapping("/reservations/getPhieuDatPhongByMaKH/{maKH}")
	public List<PhieuDatPhong> getPhieuDatPhongByMaKH(@PathVariable String maKH){
		return phieuDatPhongService.getPhieuDatPhongByMaKH(maKH);
	}
	
	@GetMapping("/reservations/getPhieuDatPhongByMaNV/{maNV}")
	public List<PhieuDatPhong> getPhieuDatPhongByMaNV(@PathVariable String maNV){
		return phieuDatPhongService.getPhieuDatPhongByMaKH(maNV);
	} 
	
	@GetMapping("/reservations/getPhieuDatPhongByTinhTrang/{tinhTrang}")
	public List<PhieuDatPhong> getPhieuDatPhongByTinhTrang(@PathVariable int tinhTrang){
		return phieuDatPhongService.getPhieuDatPhongByTinhTrang(tinhTrang);
	} 
	
	@GetMapping("/reservations/{maPhieuDatPhong}")
	public PhieuDatPhong getPhieuDatPhongById(@PathVariable String maPhieuDatPhong){
		return phieuDatPhongService.getPhieuDatPhong(maPhieuDatPhong);
	} 
	
	@PostMapping("/reservations")
	public PhieuDatPhong themPhieuDatPhong(@RequestBody PhieuDatPhong phieuDatPhong) {
		System.out.println("123\n" + phieuDatPhong);
		phieuDatPhong.setMaPhieuDatPhong("0");
		phieuDatPhongService.savePhieuDatPhong(phieuDatPhong);
		
		return phieuDatPhong;
	}
	
	@PutMapping("/reservations")
	public PhieuDatPhong suaPhieuDatPhong(@RequestBody PhieuDatPhong phieuDatPhong) {
		System.out.println("345\n" + phieuDatPhong);
		phieuDatPhongService.savePhieuDatPhong(phieuDatPhong);
		return phieuDatPhong;
	}
	
	@DeleteMapping("/reservations/maPhieuDatPhong")
	public String xoaPhieuDatPhong(@PathVariable String maPhieuDatPhong) {
		PhieuDatPhong phieuDatPhong = phieuDatPhongService.getPhieuDatPhong(maPhieuDatPhong);
		if(phieuDatPhong == null) {
			throw new RuntimeException("khong tim thay ma nay");
		}
		
		phieuDatPhongService.deletePhieuDatPhong(maPhieuDatPhong);
		return "Da xoa";
	}
	
	@GetMapping("/reservations/getPhieuDatByMaPhong/{phongId}")
	public List<PhieuDatPhong> getPhieuDatByMaPhong(@PathVariable String phongId){
		return phieuDatPhongService.getPhieuDatPhongByMaPhong(phongId);
	} 
	
}

package com.se.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.ChiTietDV;
import com.se.entity.ChiTietPhong;
import com.se.entity.DichVu;
import com.se.entity.HoaDon;
import com.se.entity.KhachHang;
import com.se.entity.PhieuDatPhong;
import com.se.entity.Phong;
import com.se.service.ChiTietDichVuService;
import com.se.service.ChiTietPhongService;
import com.se.service.DichVuService;
import com.se.service.HoaDonService;
import com.se.service.KhachHangService;
import com.se.service.PhieuDatPhongSerivce;
import com.se.service.PhongSerivce;

@Controller
@RequestMapping("/reservation")
public class PhieuDatPhongController {
	@Autowired
	private KhachHangService khachHangService;
	@Autowired
	private PhieuDatPhongSerivce phieuDatPhongSerivce;
	@Autowired
	private PhongSerivce phongService;
	@Autowired
	private HoaDonService hoaDonService;
	@Autowired
	private ChiTietPhongService chiTietPhongService;

	@Autowired
	private DichVuService dichVuService;

	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}

	@GetMapping("/showFormForAdd")
	public String datPhong(Model model) {
		KhachHang khachHang = new KhachHang("");
		model.addAttribute("customer", khachHang);
		return "reservation-form";
	}

	@GetMapping("/showFormForAddCoPhong")
	public String datPhongCoPhongSan(@ModelAttribute("roomId") String roomId, Model model) {
		KhachHang khachHang = new KhachHang("");
		model.addAttribute("customer", khachHang);
		model.addAttribute("roomId", roomId);
		return "reservation-form-co-phong";
	}
//	
	@PostMapping("/showFormForAddCoPhong2")
	public String datPhongCoPhongSan2Cont(Model model,@ModelAttribute("roomId") String roomId, @Valid @ModelAttribute("customer") KhachHang khachHang, 
			
			 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "reservation-form-co-phong";
		} else {
			PhieuDatPhong phieuDatPhong = new PhieuDatPhong();
			model.addAttribute("reservation", phieuDatPhong);
			model.addAttribute("customer", khachHang);
			int soLuongPhong = 0;
			Date ngayNhan = null, ngayTra = null;
			model.addAttribute("soLuongPhong", soLuongPhong);
			model.addAttribute("ngayNhan", ngayNhan);
			model.addAttribute("ngayTra", ngayTra);
//			System.out.println("buoc 2: " + phieuDatPhong);
			return "reservation-form-co-phong2";
		}
	}

//	
	@PostMapping("/showFormForAdd2")
	public String datPhong2Cont(Model model, @Valid @ModelAttribute("customer") KhachHang khachHang,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "reservation-form";
		} else {
			PhieuDatPhong phieuDatPhong = new PhieuDatPhong();
//			System.out.println(khachHang);
			model.addAttribute("reservation", phieuDatPhong);
			model.addAttribute("customer", khachHang);
			int soLuongPhong = 0;
			Date ngayNhan = null, ngayTra = null;
			model.addAttribute("soLuongPhong", soLuongPhong);
			model.addAttribute("ngayNhan", ngayNhan);
			model.addAttribute("ngayTra", ngayTra);
//			System.out.println("buoc 2: " + phieuDatPhong);
			return "reservation-form2";
		}
	}

	@PostMapping("/showFormForAddCoPhong3")
	public String datPhong3Cont(@ModelAttribute("reservation") PhieuDatPhong phieuDatPhong,
			@ModelAttribute("ngayNhan") String ngayNhanPhong, @ModelAttribute("ngayTra") String ngayTraPhong,
			@ModelAttribute("roomId") String roomId, Model model) throws Exception{
		phieuDatPhong.setMaPhieuDatPhong("");
//		System.out.println("buoc 3: " + phieuDatPhong);
		try {
			Date nhan = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhanPhong);
			Date tra = new SimpleDateFormat("yyyy-MM-dd").parse(ngayTraPhong);
			phieuDatPhong.setNgayNhanPhong(nhan);
			phieuDatPhong.setNgayTraPhong(tra);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		phieuDatPhong.getKhachHang().setMaKH("");
		
		khachHangService.saveKhachHang(phieuDatPhong.getKhachHang());
////		System.out.println();
//		
		phieuDatPhong.setKhachHang(khachHangService.getKhachHangs().get(0));
		Phong phong = phongService.getPhongByMaPhong(roomId).get(0);
//		
//		
		 phieuDatPhong.addCTPhong(phong, new java.util.Date());
		ChiTietPhong ctp = new ChiTietPhong(phong, new java.util.Date());
		phieuDatPhongSerivce.savePhieuDatPhong(phieuDatPhong);
		
		
		ctp.setPhieuDatPhong(phieuDatPhong);
		chiTietPhongService.saveCTP(ctp);
		
		return "reservation-form3";
	}

//	
	@PostMapping("/showFormForAdd3")
	public String datPhong3Cont(@Valid @ModelAttribute("reservation") PhieuDatPhong phieuDatPhong,
			@ModelAttribute("soLuongPhong") int soLuongPhong, @ModelAttribute("phongLoai1") String phongLoai1,
			@ModelAttribute("phongLoai2") String phongLoai2, @ModelAttribute("phongLoai3") String phongLoai3,
			@ModelAttribute("phongLoai4") String phongLoai4, @ModelAttribute("ngayNhan") String ngayNhanPhong,
			@ModelAttribute("ngayTra") String ngayTraPhong, Model model) {
		model.addAttribute("soLuongPhong", soLuongPhong);
		phieuDatPhong.setMaPhieuDatPhong("");
//		System.out.println("buoc 3: " + phieuDatPhong);
		try {
			Date nhan = new SimpleDateFormat("yyyy-MM-dd").parse(ngayNhanPhong);
			Date tra = new SimpleDateFormat("yyyy-MM-dd").parse(ngayTraPhong);
			phieuDatPhong.setNgayNhanPhong(nhan);
			phieuDatPhong.setNgayTraPhong(tra);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int phongLoai1_1 = Integer.parseInt(phongLoai1);
		int phongLoai1_2 = Integer.parseInt(phongLoai2);
		int phongLoai1_3 = Integer.parseInt(phongLoai3);
		int phongLoai1_4 = Integer.parseInt(phongLoai4);
//		System.out.println("" + phongLoai1_1 + "," + phongLoai1_2 + phongLoai1_3 + phongLoai1_4 + soLuongPhong);
		if (phongLoai1_1 + phongLoai1_2 + phongLoai1_3 + phongLoai1_4 == soLuongPhong) {
			phieuDatPhong.getKhachHang().setMaKH("");
			khachHangService.saveKhachHang(phieuDatPhong.getKhachHang());
			phieuDatPhong.setKhachHang(khachHangService.getKhachHangs().get(0));
			if (phongLoai1_1 != 0) {
				saveCTPPhiaPhieuPhong(phongLoai1_1, "lp002", phieuDatPhong);
			}
			if (phongLoai1_2 != 0) {
				saveCTPPhiaPhieuPhong(phongLoai1_2, "lp001", phieuDatPhong);
			}
			if (phongLoai1_3 != 0) {
				saveCTPPhiaPhieuPhong(phongLoai1_3, "lp004", phieuDatPhong);
			}
			if (phongLoai1_4 != 0) {
				saveCTPPhiaPhieuPhong(phongLoai1_4, "lp003", phieuDatPhong);
			}
//			System.out.println(phieuDatPhong);
			PhieuDatPhong p = phieuDatPhongSerivce.savePhieuDatPhong(phieuDatPhong);
			for (ChiTietPhong ctp : phieuDatPhong.getDsChiTietPhong()) {
				ctp.setPhieuDatPhong(p);
//				System.out.println(ctp + "\n");
				chiTietPhongService.saveCTP(ctp);
			}
			return "reservation-form3";
		} else
			return "redirect:/reservation/showFormForAdd2";
	}

	@GetMapping("/showReservationFull")
	public String showReservationFull(@RequestParam("roomId") String roomId, Model model) {
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("services", dichVus);
		model.addAttribute("roomId", roomId);
		if (phongService.getPhong(roomId).getTinhTrang() == 2) {
			PhieuDatPhong phieuDatPhong = chiTietPhongService.getPhieuDatPhongTheoMaPhong(roomId);
			model.addAttribute("reservation", phieuDatPhong);
			KhachHang customer = phieuDatPhong.getKhachHang();
			model.addAttribute("customer", customer);
			String maPhieu = phieuDatPhong.getMaPhieuDatPhong();
			model.addAttribute("maPhieu", maPhieu);
			ChiTietDV chiTietDV = new ChiTietDV();
			model.addAttribute("ctdv", chiTietDV);
			if (phieuDatPhong.getDsCTDV().size() > 0) {
				model.addAttribute("servicedetails", phieuDatPhong.getDsCTDV());
			}
			return "lap_hoa_don";
		}
		return "redirect:/reservation/showFormForAddCoPhong";
	}

//	@GetMapping("/showReservationFull")
//	public String showReservationFull( String roomId, Model model) {
//		List<DichVu> dichVus = dichVuService.getDichVus();
//		model.addAttribute("services", dichVus);
//		if (phongService.getPhong(roomId).getTinhTrang() == 2) {
//			PhieuDatPhong phieuDatPhong = chiTietPhongService.getPhieuDatPhongTheoMaPhong(roomId);
//			model.addAttribute("reservation", phieuDatPhong);
//			KhachHang customer = phieuDatPhong.getKhachHang();
//			model.addAttribute("customer", customer);
//			String maPhieu = phieuDatPhong.getMaPhieuDatPhong();
//			model.addAttribute("maPhieu", maPhieu);
//			model.addAttribute("roomId", roomId);
//			ChiTietDV chiTietDV = new ChiTietDV();
//			model.addAttribute("ctdv", chiTietDV);
//			if (phieuDatPhong.getDsCTDV().size() > 0) {
//				model.addAttribute("servicedetails", phieuDatPhong.getDsCTDV());
//			}
//			return "lap_hoa_don";
//		}
//		return "redirect:/reservation/showFormForAdd";
//	}

	@GetMapping("/addChiTietDV")
	public String addChiTietDV(@ModelAttribute("ctdv") ChiTietDV chiTietDV, @ModelAttribute("maPhieu") String maPhieu,
			@ModelAttribute("roomId") String roomId, Model model) {
		PhieuDatPhong p = phieuDatPhongSerivce.getPhieuDatPhong(maPhieu);
		p.addChiTietDV(chiTietDV.getSoLanSuDung(), dichVuService.getDichVu(chiTietDV.getDichVu().getMaDV()));
		phieuDatPhongSerivce.savePhieuDatPhong(p);
//		
		PhieuDatPhong phieuDatPhong = chiTietPhongService.getPhieuDatPhongTheoMaPhong(roomId);
		List<DichVu> dichVus = dichVuService.getDichVus();
		model.addAttribute("services", dichVus);
		model.addAttribute("reservation", phieuDatPhong);
		KhachHang customer = p.getKhachHang();
		model.addAttribute("customer", customer);
		model.addAttribute("maPhieu", maPhieu);
		model.addAttribute("roomId", roomId);
		model.addAttribute("servicedetails", phieuDatPhong.getDsCTDV());

		return "lap_hoa_don";
	}

	private void saveCTPPhiaPhieuPhong(int soLuongLoaiPhong, String maLoaiPhong, PhieuDatPhong pdp) {
		List<Phong> dsPhongTheoLoai = phongService.getPhongByMaLoaiPhong(maLoaiPhong);

		for (int i = 0; i < dsPhongTheoLoai.size(); i++) {
			if (dsPhongTheoLoai.get(i).getTinhTrang() == 1) {
				pdp.addCTPhong(dsPhongTheoLoai.get(i), new java.util.Date());
				soLuongLoaiPhong--;
			}
			if (dsPhongTheoLoai.get(i).getTinhTrang() == 4) {
				if (kiemTraPhongTrong(pdp, dsPhongTheoLoai.get(i).getMaPhong())) {
					System.out.println("thaot");
					pdp.addCTPhong(dsPhongTheoLoai.get(i), new java.util.Date());
					soLuongLoaiPhong--;
				}
			}
			if (soLuongLoaiPhong == 0) {
				break;
			}
		}
		if (soLuongLoaiPhong != 0) {
			throw new RuntimeException("Khong con trong nua");
		}
	}

	private boolean kiemTraPhongTrong(PhieuDatPhong phieuMoi, String maPhong) {
		List<PhieuDatPhong> listPhieu = phieuDatPhongSerivce.getPhieuDatPhongByMaPhong(maPhong);
		for (PhieuDatPhong phieuCu : listPhieu) {
			if (phieuMoi.getNgayTraPhong().getTime() >= phieuCu.getNgayNhanPhong().getTime()
					|| phieuMoi.getNgayNhanPhong().getTime() <= phieuCu.getNgayTraPhong().getTime()) {
				System.out.println("trung roi");
				return false;
			}
		}
		return true;
	}

	@GetMapping("/phieudat")
	public String listReservation(Model model) {
		List<PhieuDatPhong> list = phieuDatPhongSerivce.getPhieuDatPhongs();
		model.addAttribute("reservations", list);
		for (PhieuDatPhong phieuDatPhong : list) {
			System.out.println(phieuDatPhong + "xxxxxxxx");
//			System.out.println(listBills(model));
		}
		return "phieu_dat_phong";
	}

	@GetMapping("/updateReservation")
	public String updateReservation(@ModelAttribute("reservation") PhieuDatPhong phieuDatPhong,
			@RequestParam("reservationId") String reservationId) {
//		List<Phong> listPhong = null;
//		if(!loaiPhong.getMaLoai().equals("0"))
//			listPhong = phongSerivce.getPhongByMaLoaiPhong(loaiPhong.getMaLoai());
//		loaiPhong.setListPhong(listPhong);

		System.out.println("________________________________________________________________________________________"
				+ reservationId + phieuDatPhong.getMaPhieuDatPhong() + phieuDatPhong.getTinhTrangPhieuDat());
		PhieuDatPhong phieuDatPhong2 = phieuDatPhongSerivce.getPhieuDatPhong(reservationId);
		phieuDatPhong2.setTinhTrangPhieuDat(2);
		System.out.println(phieuDatPhong2.getTinhTrangPhieuDat() + "##########" + phieuDatPhong2.getMaPhieuDatPhong());
		phieuDatPhongSerivce.savePhieuDatPhong(phieuDatPhong2);
		return "redirect:/reservation/phieudat";

//		phieuDatPhong.setTinhTrangPhieuDat(2);
//		phieuDatPhongSerivce.updatePhieuDatPhong(phieuDatPhong);
//		return "redirect:/reservation/phieudat";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("reservationId") String reservationId) {
		System.out.println("xxxxxxxxx:   " + reservationId);
		phieuDatPhongSerivce.deletePhieuDatPhong(reservationId);
		return "redirect:/reservation/phieudat";
	}

	@GetMapping("/list")
	private String listBills(Model model) {
		List<HoaDon> list = hoaDonService.getHoaDons();
		model.addAttribute("bills", list);
//		model.addAttribute("billId", billId);
		System.out.println("@@@@@@@@@@@@@" + list);
		return "phieu_dat_phong";
	}
}

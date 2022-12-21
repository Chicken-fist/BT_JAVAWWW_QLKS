package com.se.controller;

import java.security.Provider.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.se.entity.DichVu;
import com.se.service.DichVuService;

@Controller
@RequestMapping("/service")
public class DichVuController {

	@Autowired
	private DichVuService dichVuService;

	@GetMapping("/list")
	public String listService(Model model) {
		List<DichVu> list = dichVuService.getDichVus();
		model.addAttribute("services", list);
		return "list-services";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		DichVu dichVu = new DichVu();
		theModel.addAttribute("service", dichVu);
		return "service-form";
	}

	@PostMapping("/saveService")
	public String saveService(@ModelAttribute("service") DichVu dichVu) {
		dichVuService.saveDichVu(dichVu);
		return "redirect:/service/list";
	}

	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("serviceId") String theId, Model theModel) {
		DichVu dichVu = dichVuService.getDichVu(theId);
		theModel.addAttribute("service", dichVu);
		return "service-form";
	}

	@GetMapping("/delete")
	public String deleteService(@RequestParam("serviceId") String theId) {
		dichVuService.deleteDichVu(theId);
		return "redirect:/service/list";
	}

	@GetMapping("/showFormForLapHoaDon")
	public String showFormForLapHoaDon(Model theModel) {
//		DichVu dichVu = new DichVu();
//		theModel.addAttribute("service", dichVu);
		return "lap_hoa_don";
	}

}

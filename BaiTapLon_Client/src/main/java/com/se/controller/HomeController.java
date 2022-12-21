package com.se.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.se.service.PhongSerivce;

@Controller
public class HomeController {
	@Autowired
	PhongSerivce phongSerivce;

	@GetMapping("/")
	public String getHomePage() {
		Date today = new Date();
		System.out.println(today);
		return "trangchu";
	}

}

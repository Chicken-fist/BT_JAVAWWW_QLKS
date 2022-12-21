package com.se.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showMyLoginPage")
	private String showMyLoginPage() {
//		return "plain-login";  // form mặc định của http
		
		return "plain-login-css2";		// form tự tạo nhưng boostrap láy từ server
		
	}
	
	  // add request mapping for /access-denied
    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "access-denied";

    }
}

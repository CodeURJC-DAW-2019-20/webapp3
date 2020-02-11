package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SesionController {
	
	@GetMapping("/")
	public String localIndex(Model model) {
		return "index";
	}
	@GetMapping("/checkout")
	public String basicCheckout(Model model) {
		return "checkout";
	}
	@GetMapping("/index")
	public String basicIndex(Model model) {
		return "index";
	}
	
	@GetMapping("/infomail")
	public String basicInfomail(Model model) {
		return "infomail";
	}
	@GetMapping("/likeit")
	public String basicLikeit(Model model) {
		return "likeit";
	}
	@GetMapping("/log")
	public String basicLog(Model model) {
		return "log";
	}
	@GetMapping("/product")
	public String basicProduct(Model model) {
		return "product";
	}
	@GetMapping("/profile")
	public String basicProfile(Model model) {
		return "profile";
	}
	@GetMapping("/store")
	public String basicStore(Model model) {
		return "store";
	}

}

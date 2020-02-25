package com.example.demo;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.collections.List;

//import es.urjc.code.security.User;
//import es.urjc.code.security.UserRepository;

@Controller
public class WebController {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private User user;
	
	@Autowired
	private Product product;
	
	@Autowired
	private Suggestion suggestion;
	
	ArrayList<Product> prestock = new ArrayList<Product>();
	ArrayList<Product> stock = new ArrayList<Product>();
	ArrayList<Suggestion> suggestionlist = new ArrayList<Suggestion>();
	ArrayList<User> userlist = new ArrayList<User>();
	
	@GetMapping("/")
	public String localIndex(Model model) {
		
		model.addAttribute("user", user);
		return "index";
	}
	@GetMapping("/checkout")
	public String basicCheckout(Model model) {
		
		model.addAttribute("user", user);
		return "checkout";
	}
	
	@GetMapping("/index")
	public String basicIndex(Model model) {
		
		model.addAttribute("user", user);
		return "index";
	}

	// -----------------------------------------------
	@GetMapping("/infomail")
	public String basicInfomail(Model model) {
		
		model.addAttribute("user", user);
		return "infomail";
	}
	@GetMapping("/likeit")
	public String basicLikeit(Model model) {
		model.addAttribute("user",user);
		return "likeit";
	}
	
	@GetMapping("/logout")
	public String basicLogout(Model model, @RequestParam HttpSession sesion) {
		user.setLogin(false);
		sesion.invalidate();
		model.addAttribute("user",user);
		return "log";
	}
	
	@GetMapping("/log")
	public String basicLog(Model model) {
		return "log";
	}
	@GetMapping("/product")
	public String basicProduct(Model model) {
		return "product";
	}
	///--------------------------------PROFILE REQUEST ---------------------------------------------
	
	@GetMapping("/profile")
	public String basicprofile(Model model, HttpServletRequest request) {
		
		user = userRepository.findByName(request.getUserPrincipal().getName());
		user.setLogin(true);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestock",prestock);
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("userlist", userRepository.findAll());
		
		return "profile";
	}
	
	@PostMapping("/profile/update")
	public String updateProfile(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String address, String city, String country, String cp, String phone) {	
		user.updateData( lastname, email, address, city, country, cp, phone);
		userRepository.save(user);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	@PostMapping("/profile/register")
	public String registerProfile(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String address, String city, String country, String cp, String phone,String password) {	
		userRepository.save(new User(name, password,lastname,email,address,city,country,cp,phone, 10,"ROLE_USER"));
		user = userRepository.findByName(request.getUserPrincipal().getName());
		user.setLogin(true);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);

		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	@PostMapping("/profile/loadProduct")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String color, String category, String size, String description, String detail) {
		product=new Product(name, color, category, size, description, detail,false);
		prestock.add(product);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	@PostMapping("/profile/infomail")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String message) {
		suggestionlist.add(new Suggestion(name,lastname,email,message));
		
		return "index";
	}
	
	@PostMapping("/profile/checkproduct")
	public String cheksproduct(Model model, HttpServletRequest request, @RequestParam String index, String name, String color, String category, String size, String description, String detail ,String action) {
	
		if (action.equals("Aceptar"))
			stock.add(new Product(name,color,category,size,description,detail,true));
		prestock.remove(Integer.parseInt(index)-1);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	
	@PostMapping("/profile/modifyproduct")
	public String modifyproduct(Model model, HttpServletRequest request, @RequestParam String index, String name, String color, String category, String size, String description, String detail ,String action) {
		
		if (action.equals("Modificar"))
			stock.add(new Product(name,color,category,size,description,detail,true));
		stock.remove(Integer.parseInt(index)-1);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	
	@PostMapping("/profile/editsuggestion")
	public String editsuggestion(Model model, HttpServletRequest request, @RequestParam String index) {
		
	
		suggestionlist.remove(Integer.parseInt(index)-1);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);
		return "profile";
	}
	
	//---------------------------------------------------------------
	@GetMapping("/store")
	public String basicStore(Model model) {
		
		model.addAttribute("user", user);
		return "store";
	}


}

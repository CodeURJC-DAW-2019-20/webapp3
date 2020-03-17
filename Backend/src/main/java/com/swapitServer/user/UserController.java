package com.swapitServer.user;


import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapitServer.MixService;
import com.swapitServer.product.ProductService;
import com.swapitServer.suggestion.SuggestionService;
import com.swapitServer.transaction.TransactionService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MixService mixService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SuggestionService suggestionService;
	
	@GetMapping("/log")
	public String basicLog(Model model) {
		return "log";
	}
	
	@Transactional
	@GetMapping("/likeit")
	public String basicLikeit(Model model, HttpServletRequest request) {

		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("productsLike", mixService.getLikeItProducts(request));
		return "likeit";
	}
	
	@PostMapping("index/addLikeIt")
	public String addProductToLikeIt(Model model, @RequestParam long id, HttpServletRequest request){
		mixService.addLikeIt(request.getUserPrincipal().getName(), id);
		model.addAttribute("user", userService.getUserInSesion(request));
		
		return "index";
	}

	@GetMapping("/basket")
	public String basicBasket (Model model, HttpServletRequest request){
		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("productsBasket", mixService.getProductsBasket());

		return "basket";
	}

	@PostMapping("index/addBasket")
	public String addProductToBasket(Model model, @RequestParam long id, HttpServletRequest request){
	mixService.addBasket(request.getUserPrincipal().getName(), id);
		model.addAttribute("user", userService.getUserInSesion(request));

		return "redirect:/index";
	}
	
	@GetMapping("/profile")
	public String basicprofile(Model model, HttpServletRequest request) {
		
		String[] auxTransactions = transactionService.getAllTransactionsFromUser(userService.getUserInSesion(request).getName());		
		model.addAttribute("buyDates", auxTransactions[0]);
		model.addAttribute("buyValues", auxTransactions[1]);
		model.addAttribute("sellDates", auxTransactions[2]);
		model.addAttribute("sellValues", auxTransactions[3]);
		model.addAttribute("stockempty", false);
		model.addAttribute("stock", productService.getAllProductinStock());
		model.addAttribute("user", userService.getUserInSesion(request));	
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));		
		model.addAttribute("prestockempty", false);
		model.addAttribute("prestock",productService.getAllProductinPreStock());
		model.addAttribute("suggestionlistempty",false);
		model.addAttribute("suggestionlist",suggestionService.getAllSuggestion());		
		model.addAttribute("userlist", userService.getAllUser());
		
		return "profile";
	}
	
	@PostMapping("/profile/register")
	public String registerProfile(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String address, String city, String country, String cp, String phone,String password) {	
		
			userService.registerUser(name, password, lastname, email, address, city, country, cp, phone);
		
	        return "emailVerification";
	

	}
	
	@PostMapping("/profile/update")
	public String updateProfile(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String address, String city, String country, String cp, String phone, String action) {	
		if (action.equals("Modificar")) {
			userService.updateUserData(name, lastname, email, address, city, country, cp, phone);
		}else {
			userService.deleteUser(name);
		}
		
		String[] auxTransactions = transactionService.getAllTransactionsFromUser(userService.getUserInSesion(request).getName());
		model.addAttribute("buyDates", auxTransactions[0]);
		model.addAttribute("buyValues", auxTransactions[1]);
		model.addAttribute("sellDates", auxTransactions[2]);
		model.addAttribute("sellValues", auxTransactions[3]);
		model.addAttribute("stockempty", false);
		model.addAttribute("stock", productService.getAllProductinStock());
		model.addAttribute("user", userService.getUserInSesion(request));	
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));		
		model.addAttribute("prestockempty", false);
		model.addAttribute("prestock",productService.getAllProductinPreStock());
		model.addAttribute("suggestionlistempty",false);
		model.addAttribute("suggestionlist",suggestionService.getAllSuggestion());		
		model.addAttribute("userlist", userService.getAllUser());
		return "profile";
	}
	
	@GetMapping("/profile/validate")
	public String validate(Model model, HttpServletRequest request, @RequestParam String name ) {
		
		userService.validateUser(name);
		
		String[] auxTransactions = transactionService.getAllTransactionsFromUser(userService.getUserInSesion(request).getName());
		model.addAttribute("buyDates", auxTransactions[0]);
		model.addAttribute("buyValues", auxTransactions[1]);
		model.addAttribute("sellDates", auxTransactions[2]);
		model.addAttribute("sellValues", auxTransactions[3]);
		model.addAttribute("stockempty", false);
		model.addAttribute("stock", productService.getAllProductinStock());
		model.addAttribute("user", userService.getUserInSesion(request));	
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));		
		model.addAttribute("prestockempty", false);
		model.addAttribute("prestock",productService.getAllProductinPreStock());
		model.addAttribute("suggestionlistempty",false);
		model.addAttribute("suggestionlist",suggestionService.getAllSuggestion());		
		model.addAttribute("userlist", userService.getAllUser());
			
		return "profile";
	}
}

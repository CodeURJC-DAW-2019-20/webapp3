package com.swapitServer.suggestion;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.swapitServer.product.ProductService;
import com.swapitServer.transaction.TransactionService;
import com.swapitServer.user.UserService;

@Controller
public class SuggestionController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private SuggestionService suggestionService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/infomail")
	public String basicInfomail(Model model, HttpServletRequest request) {	
		
		model.addAttribute("user",userService.getUserInSesion(request));
		
		return "infomail";
	}
	
	@PostMapping("/profile/infomail")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String message) {
		suggestionService.saveSuggestion(new Suggestion(name,lastname,email,message));
		
		model.addAttribute("product", productService.getAllProductinStock());
		model.addAttribute("user",userService.getUserInSesion(request));
		return "index";
	}
	
	@PostMapping("/profile/deleteSuggestion")
	public String deleteSuggestion(Model model, HttpServletRequest request, @RequestParam long id) {
		
		suggestionService.deleteSuggestion(id);
		
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

package com.swapitServer.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.swapitServer.MixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.swapitServer.suggestion.SuggestionService;
import com.swapitServer.transaction.Transaction;
import com.swapitServer.transaction.TransactionService;
import com.swapitServer.user.UserService;

@Controller
public class ProductController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private MixService mixService;
	@Autowired
	private ProductService productService;
	@Autowired
	private TransactionService transactionService;
	@Autowired
	private SuggestionService suggestionService;
	
	@GetMapping("/checkout")
	public String basicCheckout(Model model , HttpServletRequest request) {
		
		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("productsBasket", mixService.getProductsBasket(request));
		return "checkout";
	}

	@GetMapping("/product")
	public String IndexProduct(Model model, HttpServletRequest request, long id) {

		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("SpecificProduct", productService.getProductById(id));
		model.addAttribute("relatedProducts", productService.getAllProductinStockByBrandAndCategory(id, productService.getProductById(id).getBrand(), productService.getProductById(id).getCategory()));

		return "product";
	}
	
	@GetMapping("/store")
	public String basicStore(Model model , HttpServletRequest request) {

	    model.addAttribute("user", userService.getUserInSesion(request));
	    model.addAttribute("product", productService.getAllProductinStock());
		model.addAttribute("maxPrice", productService.getMaxPrice());
		model.addAttribute("minPrice", productService.getMinPrice());
		model.addAttribute("brands", productService.getAllBrands());
		model.addAttribute("categorys", productService.getAllCategorys());


		return "store";
	}
	@PostMapping("/store/filter")
	public String basicStoreByFilter(Model model , HttpServletRequest request, String[] categorys, int minPrice, int maxPrice, String[] brands) {

		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("product", productService.getProductinStockByFilter(categorys, minPrice, maxPrice, brands));
		model.addAttribute("maxPrice", productService.getMaxPrice());
		model.addAttribute("minPrice", productService.getMinPrice());
		model.addAttribute("brands", productService.getAllBrands());
		model.addAttribute("categorys", productService.getAllCategorys());

		return "store";
	}

	@GetMapping("/store/orderByName")
	public String basicStoreOrderByName(Model model , HttpServletRequest request) {

		model.addAttribute("user", userService.getUserInSesion(request));

		ArrayList<Product> productsInStock = (ArrayList<Product>) productService.getAllProductinStock();
		productsInStock.sort(new CompareProductsByName());

		model.addAttribute("product", productsInStock);

		model.addAttribute("maxPrice", productService.getMaxPrice());
		model.addAttribute("minPrice", productService.getMinPrice());
		model.addAttribute("brands", productService.getAllBrands());
		model.addAttribute("categorys", productService.getAllCategorys());

		return "store";
	}

	@GetMapping("/store/orderByPrice")
	public String basicStoreOrderByPrice(Model model , HttpServletRequest request) {

		model.addAttribute("user", userService.getUserInSesion(request));

		ArrayList<Product> productsInStock = (ArrayList<Product>) productService.getAllProductinStock();
		productsInStock.sort(new CompareProductsByPrice());

		model.addAttribute("product", productsInStock);
		model.addAttribute("maxPrice", productService.getMaxPrice());
		model.addAttribute("minPrice", productService.getMinPrice());
		model.addAttribute("brands", productService.getAllBrands());
		model.addAttribute("categorys", productService.getAllCategorys());

		return "store";
	}
	
	@PostMapping("/profile/loadProduct")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String color, String category, String brand, String size, String description, String detail, MultipartFile imagenFile) throws IOException {
		productService.saveNewProduct(name, color, category, brand, size, description, detail, imagenFile);
		
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
	
	@PostMapping("/profile/validateProduct")
	public String cheksproduct(Model model, HttpServletRequest request, @RequestParam long id, String name, String color, String category, String brand, String size, String description, String detail ,String action) {
	
		if (action.equals("Aceptar"))
			productService.validateProduct(id, name, color, category, brand, size, description, detail);
		else
			productService.deleteProduct(id);
		
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
	
	@PostMapping("/profile/modifyproduct")
	public String modifyproduct(Model model, HttpServletRequest request, @RequestParam long id, String name, String color, String category, String brand, String size, String description, String detail ,String action) {
		
		if (action.equals("Modificar"))
			productService.modifyProduct(id, name, color, category, brand, size, description, detail);
		else
			productService.deleteProduct(id);
		
		
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

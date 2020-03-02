package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;

import java.awt.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

//import es.urjc.code.security.User;
//import es.urjc.code.security.UserRepository;

@Controller
public class WebController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private  ProductRepository productRepository;
	
	@Autowired
	private User user;
	
	@Autowired
	private Product product;
	
	@Autowired
	private Suggestion suggestion;
	
    @Autowired
    private EmailSenderService emailSenderService;

    @Autowired
	private ImageService imageService;
	
	ArrayList<Product> prestock = new ArrayList<Product>();
	ArrayList<Product> stock = new ArrayList<Product>();
	ArrayList<Suggestion> suggestionlist = new ArrayList<Suggestion>();
	ArrayList<User> userlist = new ArrayList<User>();
	
	@GetMapping("/")
	public String localIndex(Model model) {

		model.addAttribute("user", user);

		List<Product> product = productRepository.findAll();

		model.addAttribute("product", product);

		return "index";
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Product newProduct(@RequestBody Product product){
		productRepository.save(product);
		return product;
	}

	@GetMapping("/checkout")
	public String basicCheckout(Model model) {
		
		model.addAttribute("user", user);
		return "checkout";
	}
	
	@GetMapping("/index")
	public String basicIndex(Model model) {
		
		model.addAttribute("user", user);

		List<Product> product = productRepository.findAll();

		model.addAttribute("product", product);

		return "index";
	}

	// -----------------------------------------------
	@GetMapping("/infomail")
	public String basicInfomail(Model model) {
		
		model.addAttribute("user", user);
		return "infomail";
	}
	@Transactional
	@GetMapping("/likeit")
	public String basicLikeit(Model model) {

		model.addAttribute("user", user);

		List<Product> products = productRepository.findAll();
		long[] productsILikeIt = user.getProductsILikeIt();
		List<Product> productsLike = new ArrayList<Product>();

		if (productsILikeIt.length != 0) {
			for (Product product : products) {
				for (int i = 0; i < productsILikeIt.length; i++){
					if (productsILikeIt[i] == product.getId()) {
						productsLike.add(product);
					}
				}
			}
		}
		model.addAttribute("productsLike", productsLike);
		return "likeit";
	}

	@PostMapping("index/addLikeIt")
	public String addProductToLikeIt(Model model, @RequestParam long id){
		model.addAttribute("user", user);

		long[] productsILikeIt = user.getProductsILikeIt();
		int i = 0;

		while (productsILikeIt[i] != 0){
			i++;
		}
		user.setProductsILikeIt(id, i);

		return "/index";
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
	public String updateProfile(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String address, String city, String country, String cp, String phone, String action) {	
		if (action.equals("Modificar")) {
			user.updateData( lastname, email, address, city, country, cp, phone);
			userRepository.save(user);
		}else {
			userRepository.delete(userRepository.findByName(name));
		}
		
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
		
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setTo(email);
        mailMessage.setSubject("Complete Registration!");
        mailMessage.setFrom("swapitserver@gmail.com");
        mailMessage.setText("To confirm your account, please click here :" +"https://localhost:8443/profile/validate?name="+name);
        try {
	        emailSenderService.sendEmail(mailMessage);
	        userRepository.save(new User(name, password,lastname,email,address,city,country,cp,phone, 100,false, "ROLE_USER"));
			return "emailVerification";
		}
        catch(Exception e) {
        	return"error";      	
        }

	}
	
	@GetMapping("/profile/validate")
	public String validate(Model model, HttpServletRequest request, @RequestParam String name ) {
		
		user = userRepository.findByName(name);
		user.setLogin(true);
		user.setEmailVerified(true);
		userRepository.save(user);
		
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
	
	@PostMapping("/{id}/imagen")
	public ResponseEntity<Product> newImageProduct (@PathVariable long id, @RequestParam MultipartFile imagenFile) throws IOException {
		Product product = productRepository.findById(id);

		if (product != null){

			product.setHasImage(true);
			productRepository.save(product);

			imageService.saveImage("productos", product.getId(), imagenFile);
			return new ResponseEntity<>(HttpStatus.CREATED);

		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/{id}/imagen")
	public ResponseEntity<Object> getImageProduct (@PathVariable long id) throws IOException {
		Product product = productRepository.findById(id);

		if (product != null) {
			if (product.hasImage()) {
				return this.imageService.createResponseFromImage("productos", id);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/profile/loadProduct")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String color, String category, String brand, String size, String description, String detail, MultipartFile imagenFile) throws IOException {
		product = new Product(name, color, category, brand, size, description, detail, false);
		prestock.add(product);
		
		model.addAttribute("stockempty", stock.isEmpty());
		model.addAttribute("stock",stock);
		model.addAttribute("user",user);
		model.addAttribute("admin",request.isUserInRole("ROLE_ADMIN"));
		model.addAttribute("prestockempty", prestock.isEmpty());
		model.addAttribute("prestock",prestock);
		model.addAttribute("suggestionlistempty",suggestionlist.isEmpty());
		model.addAttribute("suggestionlist",suggestionlist);

		product.setHasImage(true);
		productRepository.save(product);

		imageService.saveImage("products", product.getId(), imagenFile);

		return "profile";
	}
	
	@PostMapping("/profile/infomail")
	public String register(Model model, HttpServletRequest request, @RequestParam String name, String lastname, String email, String message) {
		suggestionlist.add(new Suggestion(name,lastname,email,message));
		
		return "index";
	}
	
	@PostMapping("/profile/checkproduct")
	public String cheksproduct(Model model, HttpServletRequest request, @RequestParam String index, String name, String color, String category, String brand, String size, String description, String detail ,String action) {
	
		if (action.equals("Aceptar"))
			stock.add(new Product(name, color, category, brand, size, description, detail, true));
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
	public String modifyproduct(Model model, HttpServletRequest request, @RequestParam String index, String name, String color, String category, String brand, String size, String description, String detail ,String action) {
		
		if (action.equals("Modificar"))
			stock.add(new Product(name, color, category, brand, size, description, detail, true));
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

	@GetMapping ("/product/{id}")
    public String verProducto(Model model, @PathVariable long id){

	    Product product = productRepository.findById(id);
	    if (product != null){
	        model.addAttribute("producto", product);
        }

	    return "ver Producto";
    }

	//---------------------------------------------------------------
	@GetMapping("/store")
	public String basicStore(Model model) {

	    List<Product> product = productRepository.findAll();

	    model.addAttribute("product", product);

		return "store";
	}

}

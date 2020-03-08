package com.swapitServer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.swapitServer.product.Product;
import com.swapitServer.product.ProductService;
import com.swapitServer.suggestion.Suggestion;
import com.swapitServer.user.User;
import com.swapitServer.user.UserService;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;


@Controller
public class WebController {


	@Autowired
	private UserService userService;
    @Autowired
    private ProductService productService;
    @Autowired
	private MixService mixService;
	
	
	@GetMapping("/")
	public String localIndex(Model model , HttpServletRequest request) {

		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("product", productService.getAllProductinStock());

		return "index";
	}

	@PostMapping("/")
	@ResponseStatus(HttpStatus.CREATED)
	public Product newProduct(@RequestBody Product product){
		productService.saveProduct(product);
		return product;
	}

	
	@GetMapping("/index")
	public String basicIndex(Model model, HttpServletRequest request) {
		
		model.addAttribute("user", userService.getUserInSesion(request));
		model.addAttribute("product", productService.getAllProductinStock());

		return "index";
	}

	
	@PostMapping("/{id}/imagen")
	public ResponseEntity<Product> newImageProduct (@PathVariable long id, @RequestParam MultipartFile imagenFile) throws IOException {		
		return mixService.newProductImagen(imagenFile, id);
	}

	@GetMapping("/{id}/imagen")
	public ResponseEntity<Object> getImageProduct (@PathVariable long id) throws IOException {
		
		return mixService.getImage(id);
	}
		
	


	@GetMapping ("/product/{id}")
    public String verProducto(Model model, @PathVariable long id){

	    Product product=productService.getProductById(id);
	    if (product != null){
	        model.addAttribute("producto", product);
        }

	    return "ver Producto";
    }



}

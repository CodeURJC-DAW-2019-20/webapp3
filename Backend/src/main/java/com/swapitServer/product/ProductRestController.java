package com.swapitServer.product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.swapitServer.ImageService;



@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ImageService imageService;
	
	@RequestMapping(value="/load", method=RequestMethod.POST)
	public ResponseEntity<Product> loadProduct( @RequestBody Product product) {			
			
		productService.saveNewProduct(product.getName(), product.getColor(), product.getCategory(), product.getBrand(), product.getSize(), product.getDescription(), product.getDetail());
		return new ResponseEntity<>(productService.getProductById(product.getId()),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}/imagen", method=RequestMethod.POST)
	public ResponseEntity<Product> nuevaImagenAnuncio(@PathVariable long id, @RequestParam MultipartFile imagenFile) throws IOException {
		Product product = productService.getProductById(id);
		if (product != null) {
			product.setHasImage(true);
			productService.modifyProduct(product);
			imageService.saveImage("products", product.getId(), imagenFile);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}/imagen", method=RequestMethod.GET)
	public ResponseEntity<Object> nuevaImagenAnuncio(@PathVariable long id) throws IOException {
		Product product = productService.getProductById(id);
		if (product != null) 
			if(product.hasImage())
				return imageService.createResponseFromImage("products", id);
		 	else 
		 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		else 
	 		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	
	@RequestMapping(value="/validate", method=RequestMethod.PUT)
	public ResponseEntity<Product> validateProduct(@RequestParam long id , @RequestBody Product product) {	
		if(productService.getProductById(id) != null) {
			productService.validateProduct(id, product.getName(), product.getColor(), product.getCategory(), product.getBrand(), product.getSize(), product.getDescription(), product.getDetail());
			return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/modify", method=RequestMethod.DELETE)
	public ResponseEntity<Product> modifyProduct(@RequestParam long id) {	
		if(productService.getProductById(id) != null) {
			productService.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	

	@RequestMapping(value="/modify", method=RequestMethod.PUT)
	public ResponseEntity<Product> modifyProduct( @RequestBody Product product) {	
		if(productService.getProductById(product.getId()) != null) {
			productService.modifyProduct(product);
			return new ResponseEntity<>(productService.getProductById(product.getId()),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ResponseEntity<Product> readProduct(@RequestParam long id) {	
		if(productService.getProductById(id) != null) {			
			return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
		}else
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	}
	
	@RequestMapping(value="/stock", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> readAllStockProducts() {			
			return new ResponseEntity<>(productService.getAllProductinStock(),HttpStatus.OK);
	}	
	@RequestMapping(value="/stock/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Product>> readAllStockProductsPage(Pageable page) {	
		return new ResponseEntity<>(productService.getAllProductinStock(page),HttpStatus.OK);
	}
	
	@RequestMapping(value="/prestock", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> readAllPreStockProducts() {			
			return new ResponseEntity<>(productService.getAllProductinPreStock(),HttpStatus.OK);
	}
	@RequestMapping(value="/prestock/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Product>> readAllPreStockProductsPage(Pageable page) {	
		return new ResponseEntity<>(productService.getAllProductinPreStock(page),HttpStatus.OK);
	}
	
	@RequestMapping(value="/filter", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> readFilter(@RequestParam  String[] categorys, @RequestParam  int minPrice, @RequestParam  int maxPrice, @RequestParam String[] brands) {
		return new ResponseEntity<>(productService.getProductinStockByFilter(categorys, minPrice,maxPrice,brands),HttpStatus.OK);
			
	}
}

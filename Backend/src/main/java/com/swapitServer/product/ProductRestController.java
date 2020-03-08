package com.swapitServer.product;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



@RestController
@RequestMapping("/api/product")
public class ProductRestController {
	
	@Autowired
	private ProductService productService;
/*	
	@RequestMapping(value="/load", method=RequestMethod.POST)
	public ResponseEntity<Product> loadProduct( @RequestBody Product product, MultipartFile imagenFile) throws IOException {			
			
		productService.saveNewProduct(product.getName(), product.getColor(), product.getCategory(), product.getBrand(), product.getSize(), product.getDescription(), product.getDetail(), imagenFile);
		return new ResponseEntity<>(productService.getProductById(product.getId()),HttpStatus.OK);
	}
*/	
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
	public ResponseEntity<Product> modifyProduct(@RequestParam long id , @RequestBody Product product) {	
		if(productService.getProductById(id) != null) {
			productService.modifyProduct(id, product.getName(), product.getColor(), product.getCategory(), product.getBrand(), product.getSize(), product.getDescription(), product.getDetail());
			return new ResponseEntity<>(productService.getProductById(id),HttpStatus.OK);
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
	
	@RequestMapping(value="/prestock", method=RequestMethod.GET)
	public ResponseEntity<List<Product>> readAllPreStockProducts() {			
			return new ResponseEntity<>(productService.getAllProductinPreStock(),HttpStatus.OK);
	}
}

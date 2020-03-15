package com.swapitServer.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.swapitServer.ImageService;
import com.swapitServer.product.*;

@Component
public class ProductService<T> {
	
	@Autowired
	private ProductRepository productRepository;
    @Autowired
	private ImageService imageService;
	
	public Product getProductById(long id) {
		return productRepository.findById(id);	  
	}

	
	public void saveProduct(Product product) {
		productRepository.save(product);
	}
	
	public List<Product> getAllProductinStock(){			
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(true, true);
	}
	public Page<Product> getAllProductinStock(Pageable page){	
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(true, true, page);
	}
	
	
	public List<Product> getAllProductinPreStock(){
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(false, true);		
	}
	public Page<Product> getAllProductinPreStock(Pageable page){	
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(false, true, page);
	}
	
	
	
	
	public void saveNewProduct(String name, String color, String category, String brand, String size, String description, String detail, MultipartFile imagenFile) throws IOException {
		Product	product = new Product(name, color, category, brand, size, description, detail, false,true);
		product.setHasImage(true);
		productRepository.save(product);
		imageService.saveImage("products", product.getId(), imagenFile);
	}
	
	public void validateProduct(long id, String name, String color, String category, String brand, String size, String description, String detail) {
		Product auxProduct = productRepository.findById(id);
		auxProduct.updateProductData(name, color, category, brand, size, description, detail);
		auxProduct.setVerify(true);
		productRepository.save(auxProduct);
	}
	
	public void modifyProduct(long id, String name, String color, String category, String brand, String size, String description, String detail){
		Product auxProduct = productRepository.findById(id);
		auxProduct.updateProductData(name, color, category, brand, size, description, detail);
		productRepository.save(auxProduct);
	}
	public void modifyProduct(Product product){
		productRepository.save(product);
	}
	
	public void deleteProduct(long id) {
		productRepository.deleteById(id);
	}
	
	
	
	

}

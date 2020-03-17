package com.swapitServer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.swapitServer.product.*;
import com.swapitServer.user.*;

@Component
public class MixService {
	
	@Autowired
	UserRepository userRepository;	
	@Autowired
	ProductRepository productRepository;
    @Autowired
	private ImageService imageService;
    
	
	public List<Product> getLikeItProducts(HttpServletRequest request){
		return userRepository.findByName(request.getUserPrincipal().getName()).getLikekIts();
	}

	public List<Product> getProductsBasket(HttpServletRequest request){
		return userRepository.findByName(request.getUserPrincipal().getName()).getProductsBasket();
	}

	
	
	public List<Product> deleteProductsBasket(HttpServletRequest request){
		userRepository.findByName(request.getUserPrincipal().getName()).getProductsBasket().clear();

		return new ArrayList<>();
	}

	public void addLikeIt(String name, long idProduct) {
		User auxUser = userRepository.findByName(name);
		Product auxProduct = productRepository.findById(idProduct);
		auxUser.setLikeit(auxProduct);
		auxUser.setItemsILikeIt(auxUser.getLikekIts().size());
		userRepository.save(auxUser);

	}
	/*public void addBasket(HttpServletRequest request, long idProduct) {
		User auxUser = userRepository.findByName(request.getUserPrincipal().getName());
		Product auxProduct = productRepository.findById(idProduct);
		auxUser.setProductBasket(auxProduct);
		userRepository.save(auxUser);
	}
	*/
	public void addBasket(String name, long idProduct) {
		User auxUser = userRepository.findByName(name);
		Product auxProduct = productRepository.findById(idProduct);
		auxUser.setProductBasket(auxProduct);
		userRepository.save(auxUser);
	}
	public ResponseEntity<Object> getImage(long id) throws MalformedURLException{	
		Product product = productRepository.findById(id);
		if (product != null) {
			if (product.hasImage()) {
				return imageService.createResponseFromImage("productos", id);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	public ResponseEntity<Product> newProductImagen(MultipartFile imagenFile, long id) throws IOException{
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
	
}

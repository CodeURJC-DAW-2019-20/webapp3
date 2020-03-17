package com.swapitServer.product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
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

	public Product getProductById(Long id) {
		List<Product> products =  productRepository.findAll();
		Product productAux = new Product();
		while (productAux.getName() == ""){
			for (Product product: products){
				if (product.getId() == id){
					productAux = product;
				}
			}
		}

		return productAux;
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
	public List<Product> getProductinStockByFilter(String[] categorys, int minPrice, int maxPrice, String[] brands){
		// Cambiar por una Busqueda SQL que devuelva la lista filtrada
		List<Product> products = productRepository.findAll();
		List<Product> auxList = new ArrayList<Product>();

		if (categorys == null){
			categorys = fillCategorys();
		}

		if (brands == null){
			brands = fillBrands();
		}

		for(Product aux: products) {
			for (int i = 0; i < categorys.length; i++) {
				for (int j = 0; j < brands.length; j++) {
					if (aux.getInStock() && aux.getVerify() && (aux.getCategory().equals(categorys[i])) && (aux.getBrand().equals(brands[j])) && (aux.getPrice() >= minPrice) && (aux.getPrice() <= maxPrice)){
						auxList.add(aux);
					}
				}
			}
		}

		auxList.sort(new CompareProductsByName());
		return auxList;
	}

	public List<Product> getAllProductinStockByBrandAndCategory(long id, String brand, String category){
		// Cambiar por una Busqueda SQL que devuelva la lista filtrada
		List<Product> products = productRepository.findAll();
		List<Product> auxList = new ArrayList<Product>();
		for(Product aux: products)
			if(aux.getInStock() && aux.getVerify() && aux.getBrand().equals(brand) && aux.getCategory().equals(category) && aux.getId() != id)
				auxList.add(aux);

		auxList.sort(new CompareProductsByName());
		return auxList;
	}
	
	public List<Product> getAllProductinPreStock(){
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(false, true);		
	}
	public Page<Product> getAllProductinPreStock(Pageable page){	
		return productRepository.findByVerifyAndInStockOrderByCategoryDesc(false, true, page);
	}
	
	public List<Product> getProductinStockByName(){
		List<Product> products = productRepository.findAll();
		products.sort(new CompareProductsByName());
		
		
		return products;
	}
	
	public List<Product> getProductinStockByPrice(){
		List<Product> products = productRepository.findAll();
		products.sort(new CompareProductsByPrice());
		
		return products;
	}
	
	
	public void saveNewProduct(String name, String color, String category, String brand, String size, String description, String detail, MultipartFile imagenFile) throws IOException {
		Product	product = new Product(name, color, category, brand, size, description, detail, false,true,false);
		product.setHasImage(true);
		productRepository.save(product);
		imageService.saveImage("products", product.getId(), imagenFile);
	}	
	public void saveNewProduct(String name, String color, String category, String brand, String size, String description, String detail){
		Product	product = new Product(name, color, category, brand, size, description, detail, false,true,false);
		product.setHasImage(true);
		productRepository.save(product);
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

	public int getMaxPrice (){
		float price = 0;

		for (Product product: getAllProductinStock()){
			if (product.getPrice() > price){
				price = product.getPrice();
			}
		}
		int priceAux = (int) price;

		return priceAux;
	}

	public int getMinPrice (){
		float price = Float.MAX_VALUE;

		for (Product product: getAllProductinStock()){
			if (product.getPrice() < price){
				price = product.getPrice();
			}
		}

		int priceAux = (int) price;

		return priceAux;
	}

	public HashSet<String> getAllBrands (){
		HashSet<String> brands = new HashSet<>();

		for (Product product: getAllProductinStock()){
			brands.add(product.getBrand());
		}
		return brands;
	}

	public HashSet<String> getAllCategorys (){
		HashSet<String> categorys = new HashSet<>();

		for (Product product: getAllProductinStock()){
			categorys.add(product.getCategory());
		}
		return categorys;
	}

	public String[] fillCategorys (){
		String[] categorys = new String[11];

		categorys[0] = "Abrigo";
		categorys[1] = "Accesorio";
		categorys[2] = "Bota";
		categorys[3] = "Camisa";
		categorys[4] = "Camiseta";
		categorys[5] = "Chaqueta";
		categorys[6] = "Falda";
		categorys[7] = "Jersey";
		categorys[8] = "Vaquero";
		categorys[9] = "Zapatilla";
		categorys[10] = "Zapato";

		return categorys;
	}

	public String[] fillBrands (){
		HashSet<String> allBrands = getAllBrands();
		String[] newBrands = new String[allBrands.size()];
		int i = 0;

		for (String brand: allBrands){
			newBrands[i] = brand;
			i++;
		}

		return newBrands;
	}
	
	

}

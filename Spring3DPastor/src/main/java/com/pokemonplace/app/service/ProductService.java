package com.pokemonplace.app.service;

import com.pokemonplace.app.entity.Product;
import com.pokemonplace.app.entity.User;

public interface ProductService {
	
	Product getProductById(Long id);
	Product getProductByName(String name);
	Product createProduct(Product product);
	Product updateProduct(Product product, Long id);
	void deleteProduct(Long id);
	void deactivateProduct(Long id);
}

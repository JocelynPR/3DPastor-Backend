package com.pokemonplace.app.service;

import java.util.List;

import com.pokemonplace.app.dto.ProductDto;
import com.pokemonplace.app.entity.Product;

public interface ProductDtoService {
	
	ProductDto getProductById(Long id);
	ProductDto getProductByTitle(String title);
	ProductDto createProduct(Product product);
	List<ProductDto> getAllProducts();
	ProductDto updateProduct(Product product, Long id);
	void deleteProduct(Long id);
	

}

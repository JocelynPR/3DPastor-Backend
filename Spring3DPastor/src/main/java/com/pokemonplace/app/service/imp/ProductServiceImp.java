package com.pokemonplace.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.entity.*;
import com.pokemonplace.app.repository.ProductRepository;
import com.pokemonplace.app.service.ProductService;

@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired
	ProductRepository productRepository;
	
	@Override
	public Product getProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if( productOptional.isPresent())return productOptional.get();
		else throw new IllegalStateException("Id not found " + id); 
	}
	

	@Override
	public Product getProductByName(String name) {
		Optional<Product> productOptional = productRepository.findByNameProduct(name);
		if( productOptional.isPresent())return productOptional.get();
		else throw new IllegalStateException("Email not found " + name);
	}

	@Override
	public Product createProduct(Product product) {
		product.setId(null);
		Product newProduct = productRepository.save(product);
		return newProduct;
	}
	
	@Override
	public List<Product> getAllProducts() {
		List <Product> products = (List<Product>) productRepository.findAllByActive(true);
		return products;
	}

	@Override
	public Product updateProduct(Product product, Long id) {
		Product existingProduct = getProductById(id);
	
		existingProduct.setNameProduct(product.getNameProduct());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setQty(product.getQty());
		
		return productRepository.save(existingProduct);
	}

	@Override
	public void deactivateProduct(Long id) {
		Product existingProduct = getProductById(id);
		existingProduct.setActive(false);
		productRepository.save(existingProduct);
	}
}

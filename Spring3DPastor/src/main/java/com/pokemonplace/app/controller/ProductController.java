package com.pokemonplace.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.Product;
import com.pokemonplace.app.service.ProductService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/products")
@Log4j2
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping
	List<Product> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return products;
	}
	
	@GetMapping("{id}")
	Product getProductById(@PathVariable(name= "id") Long id) {
		log.info("Datos del Id " + id);
		Product product = productService.getProductById(id);
		return product;
	}
	
	@PostMapping
	Product setProduct(@RequestBody Product product){
		log.info("Agregando producto");
		log.info(product);
		Product newProduct = productService.createProduct(product);
		return newProduct;
	}
	
	@GetMapping("query")
	Product getUProductByName(@RequestParam(name= "nameProduct") String name) {
		return productService.getProductByName(name);
	}
	
	@PutMapping("{id}")
	Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
		return productService.updateProduct(product, id);
	}
	
	@DeleteMapping("{id}")
	String deleteUser(@PathVariable("id") Long id){
		productService.deleteProduct(id);
		return "Se eliminó el producto con el id= " + id;
	}
	
	@PutMapping("{id}/deactivate")
	String deactivateProduct(@PathVariable("id") Long id) {
		productService.deactivateProduct(id);
		return "Se desactivó el producto con id " + id;
	}
}

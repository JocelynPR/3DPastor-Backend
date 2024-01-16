package com.pokemonplace.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.dto.ProductDto;
import com.pokemonplace.app.entity.Product;
import com.pokemonplace.app.service.ProductDtoService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v2/products")
public class ProductDtoController {
	
	@Autowired
	ProductDtoService productDtoService;
	
	@GetMapping
	ResponseEntity<List<ProductDto>> getAllProducts() {
		List<ProductDto> productsDto = productDtoService.getAllProducts();
		return new  ResponseEntity<>(productsDto, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	ResponseEntity<ProductDto> getProductById(@PathVariable("id") Long id){
		ProductDto productDto = productDtoService.getProductById(id);
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}
	
	@PostMapping
	ResponseEntity<ProductDto> setProduct(@Validated @RequestBody Product product) {
		ProductDto newProductDto = productDtoService.createProduct(product);
		return new ResponseEntity<>(newProductDto, HttpStatus.CREATED);
	}
	
	@GetMapping("query")
	ResponseEntity<ProductDto> getProductByTitle(@RequestParam(name="title") String title) {
		ProductDto productDto = productDtoService.getProductByTitle(title);
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	ResponseEntity<ProductDto> updatedProduct(@RequestBody Product product, @PathVariable("id") Long id){
		ProductDto productDto = productDtoService.updateProduct(product, id);
		return new ResponseEntity<>(productDto, HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	ResponseEntity<String> deleteProduct(@PathVariable("id") Long id) {
		productDtoService.deleteProduct(id);
		return new ResponseEntity<>("Product id " + id + " succesfully deleted", HttpStatus.OK);
	}

}

package com.pokemonplace.app.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.ShoppingHasProducts;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;
import com.pokemonplace.app.service.ShoppingHasProductsService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/shopping-has-products")
public class ShoppingHasProductsController {
	

	@Autowired
	ShoppingHasProductsService shoppingHasProductsService;
	
	@Autowired
	ShoppingProductKey idShoppingProductKey ;
	
	@GetMapping
	ResponseEntity< List<ShoppingHasProducts> > getAllShoppingHasProducts(){
		List<ShoppingHasProducts> shopping = shoppingHasProductsService.getAllShoppingHasProducts();
		return new ResponseEntity<>(shopping, HttpStatus.OK );
	}
	
	@GetMapping("/{shoppingId}/{productId}")
	ResponseEntity<ShoppingHasProducts> getShoppingById(
			@PathVariable("shoppingId") Long shoppingId, 
			@PathVariable("productId") Long productId
			) {
		idShoppingProductKey.setShoppingId(shoppingId);
		idShoppingProductKey.setProductId(productId);
		ShoppingHasProducts shoppingHasProducts = shoppingHasProductsService.getShoppingById(idShoppingProductKey );
		return new ResponseEntity<>(shoppingHasProducts, HttpStatus.OK );
	}
	
	@PostMapping
	ResponseEntity<ShoppingHasProducts> createShopping(@Validated @RequestBody ShoppingHasProducts shoppingHasProducts) {	
		ShoppingHasProducts newShoppingHasProducts = shoppingHasProductsService.createShoppingHasProducts(shoppingHasProducts);
		return new ResponseEntity<>(newShoppingHasProducts, HttpStatus.CREATED );
	}	
	
	

	@PutMapping("/{shoppingId}/{productId}")
	ResponseEntity<ShoppingHasProducts> updateShoppingHasProducts(
			@RequestBody ShoppingHasProducts shoppingHasProducts, 
			@PathVariable("shoppingId") Long shoppingId, 
			@PathVariable("productId") Long productId
			) {
		idShoppingProductKey.setShoppingId(shoppingId);
		idShoppingProductKey.setProductId(productId);
		ShoppingHasProducts updatedShoppingHasProducts = shoppingHasProductsService.updateShoppingHasProducts(shoppingHasProducts, idShoppingProductKey);
		return new ResponseEntity<>(updatedShoppingHasProducts, HttpStatus.OK );
	}
	
	@DeleteMapping("/{shoppingId}/{productId}")
	ResponseEntity<String> deleteShoppingHasProducts(
			@PathVariable("shoppingId") Long shoppingId, 
			@PathVariable("productId") Long productId 
			) {		
		idShoppingProductKey.setShoppingId(shoppingId);
		idShoppingProductKey.setProductId(productId);
		shoppingHasProductsService.deleteShoppingHasProducts(idShoppingProductKey);
		return new ResponseEntity<>("Order-Product id " + idShoppingProductKey + " successfully deleted", HttpStatus.OK );
	}
}
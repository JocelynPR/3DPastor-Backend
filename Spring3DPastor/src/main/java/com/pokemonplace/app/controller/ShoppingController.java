package com.pokemonplace.app.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pokemonplace.app.entity.Shopping;
import com.pokemonplace.app.service.ShoppingService;


import lombok.extern.log4j.Log4j2;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/shoppings")
@Log4j2
public class ShoppingController {

	@Autowired
	ShoppingService shoppingService;
	
	// Modifications
	@GetMapping
	List<Shopping> getAllShoppings(){
		List<Shopping> shoppings = shoppingService.getAllShoppings();
		return shoppings;
	}
	
	@GetMapping("{id}")
	Shopping getShoppingById(@PathVariable(name= "id") Long id) {
		log.info("Datos del Id " + id);
		Shopping shopping = shoppingService.getShoppingById(id);
		return shopping;
	}
	
	@PostMapping
	Shopping setShopping(@RequestBody Shopping shopping){
		log.info("Creando compra");
		log.info(shopping);
		Shopping newShopping = shoppingService.createShopping(shopping);
		return newShopping;
	}
	
	@GetMapping("query")
	Shopping getShoppingByFechaCompra(@RequestParam(name= "date") Timestamp date) {
		return shoppingService.getShoppingByDate(date);
	}
	
	@PutMapping("{id}")
	Shopping updateShopping(@RequestBody Shopping shopping, @PathVariable("id") Long id){
		return shoppingService.updateShopping(shopping, id);
	}
	
	@DeleteMapping("{id}")
	String deleteShopping(@PathVariable("id") Long id){
		shoppingService.deleteShopping(id);
		return "Se eliminó la compra con el id= " +id;
	}
	
}

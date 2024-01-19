package com.pokemonplace.app.service;

import java.sql.Timestamp;
import java.util.List;

import com.pokemonplace.app.entity.Shopping;

public interface ShoppingService {
	
	Shopping getShoppingById(Long id);
	Shopping getShoppingByDate(Timestamp date);
	Shopping createShopping(Shopping shopping);
	Shopping updateShopping(Shopping shopping, Long id);
	void deleteShopping(Long id);
	List<Shopping> getAllShoppings();
}

package com.pokemonplace.app.service;

import java.sql.Timestamp;

import com.pokemonplace.app.entity.Shopping;

public interface ShoppingService {
	
	Shopping getShoppingById(Long id);
	Shopping getShoppingByDate(Timestamp date);
	Shopping createShopping(Shopping shopping);
	Shopping updateShopping(Shopping shopping, Long id);
	void deleteShopping(Long id);

}

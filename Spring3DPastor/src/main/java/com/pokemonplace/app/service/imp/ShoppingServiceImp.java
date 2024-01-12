package com.pokemonplace.app.service.imp;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.entity.*;
import com.pokemonplace.app.repository.ShoppingRepository;
import com.pokemonplace.app.service.ShoppingService;

@Service
public class ShoppingServiceImp implements ShoppingService{
	
	@Autowired
	ShoppingRepository shoppingRepository;

	@Override
	public Shopping getShoppingById(Long id) {
		Optional<Shopping> shoppingOptional = shoppingRepository.findById(id);
		if( shoppingOptional.isPresent())return shoppingOptional.get();
		else throw new IllegalStateException("Id not found " + id); 
	}

	@Override
	public Shopping getShoppingByDate(Timestamp date) {
		Optional<Shopping> shoppingOptional = shoppingRepository.findByDate(date);
		if( shoppingOptional.isPresent())return shoppingOptional.get();
		else throw new IllegalStateException("Date not found " + date); 
	}

	@Override
	public Shopping createShopping(Shopping shopping) {
		shopping.setId(null);
		Shopping newShopping = shoppingRepository.save(shopping);
		return newShopping;
	}

	@Override
	public Shopping updateShopping(Shopping shopping, Long id) {
		Shopping existingShopping = getShoppingById(id);
		
		existingShopping.setUserId(shopping.getUserId());
		existingShopping.setDate(shopping.getDate());
		existingShopping.setStatus(shopping.getStatus());
		
		return shoppingRepository.save(existingShopping);
	}

	@Override
	public void deleteShopping(Long id) {
		Shopping existingShopping = getShoppingById(id);
		shoppingRepository.delete(existingShopping);
		
	}

}

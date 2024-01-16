package com.pokemonplace.app.service.imp;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.entity.ShoppingHasProducts;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;
import com.pokemonplace.app.repository.ShoppingHasProductsRepository;
import com.pokemonplace.app.service.ShoppingHasProductsService;


@Service
public class ShoppingHasProductsImp  implements ShoppingHasProductsService{
	@Autowired
	ShoppingHasProductsRepository shoppingHasProductsRepository;

	@Override
	public ShoppingHasProducts getShoppingById(ShoppingProductKey id) {
		return shoppingHasProductsRepository.findById(id)
				.orElseThrow( ()-> new IllegalStateException("Order-Product does not exist with id " + id));
	}

	@Override
	public ShoppingHasProducts createShoppingHasProducts(ShoppingHasProducts shoppingHasProducts) {

		return shoppingHasProductsRepository.save(shoppingHasProducts);
	}

	@Override
	public List<ShoppingHasProducts> getAllShoppingHasProducts() {
		return (List<ShoppingHasProducts>) shoppingHasProductsRepository.findAll();
	}

	@Override
	public ShoppingHasProducts updateShoppingHasProducts(ShoppingHasProducts shoppingHasProducts, ShoppingProductKey id) {
		ShoppingHasProducts existingShoppingHasProducts = getShoppingById(id);
		existingShoppingHasProducts.setQuantity( shoppingHasProducts.getQuantity() );		
		return shoppingHasProductsRepository.save( existingShoppingHasProducts );
	}

	@Override
	public void deleteShoppingHasProducts(ShoppingProductKey id) {
		ShoppingHasProducts existingShoppingHasProducts = getShoppingById(id);
		shoppingHasProductsRepository.delete(existingShoppingHasProducts);

	}





}











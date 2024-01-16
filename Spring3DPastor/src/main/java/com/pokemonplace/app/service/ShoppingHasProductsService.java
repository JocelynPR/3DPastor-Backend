package com.pokemonplace.app.service;
import java.util.List;

import com.pokemonplace.app.entity.ShoppingHasProducts;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;


public interface ShoppingHasProductsService {
	

	ShoppingHasProducts getShoppingById(ShoppingProductKey id);
	ShoppingHasProducts createShoppingHasProducts(ShoppingHasProducts shoppingHasProducts);
	List<ShoppingHasProducts> getAllShoppingHasProducts();
	ShoppingHasProducts updateShoppingHasProducts(ShoppingHasProducts shoppingHasProducts, ShoppingProductKey id);
	void deleteShoppingHasProducts (ShoppingProductKey id);

}



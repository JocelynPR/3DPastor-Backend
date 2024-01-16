package com.pokemonplace.app.repository;
import org.springframework.data.repository.CrudRepository;
import com.pokemonplace.app.entity.ShoppingHasProducts;
import com.pokemonplace.app.entity.compositeKey.ShoppingProductKey;


public interface ShoppingHasProductsRepository extends CrudRepository <ShoppingHasProducts, ShoppingProductKey> {
	
}

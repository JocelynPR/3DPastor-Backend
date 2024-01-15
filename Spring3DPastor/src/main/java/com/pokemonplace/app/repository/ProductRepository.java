package com.pokemonplace.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pokemonplace.app.entity.Product;


public interface ProductRepository extends CrudRepository<Product, Long>{
	
	Optional<Product>findByNameProduct(String nameProduct);
	Iterable<Product>findAllByActive(boolean state);
}

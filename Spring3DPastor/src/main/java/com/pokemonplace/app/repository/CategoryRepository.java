package com.pokemonplace.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.pokemonplace.app.entity.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
}
package com.pokemonplace.app.repository;

import java.sql.Timestamp;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pokemonplace.app.entity.Shopping;


public interface ShoppingRepository extends CrudRepository<Shopping, Long>{
	
	Optional<Shopping>findByDate(Timestamp date);
	Iterable<Shopping> findAll();
}

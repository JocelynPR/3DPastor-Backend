package com.pokemonplace.app.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pokemonplace.app.entity.Image;

public interface ImageRepository extends CrudRepository<Image, Long>{
	
	Optional<Image>findByImageName(String imageName);
}

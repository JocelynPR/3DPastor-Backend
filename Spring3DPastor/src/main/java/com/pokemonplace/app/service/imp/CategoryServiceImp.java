package com.pokemonplace.app.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.entity.Category;
import com.pokemonplace.app.repository.CategoryRepository;
import com.pokemonplace.app.service.CategoryService;

@Service
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Override
	public Category getCategoryByCategoryId(Long categoryId) {
		Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
		if( categoryOptional.isPresent()) return categoryOptional.get();
		else throw new IllegalStateException("Category Id not found " + categoryId);
	}

}

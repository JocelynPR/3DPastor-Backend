package com.pokemonplace.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.Category;
import com.pokemonplace.app.service.CategoryService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/categories")
@Log4j2
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping("{categoryId}")
	Category getCategoryByCategoryId(@PathVariable(name="categoryId") Long categoryId) {
		log.info("Datos del Id de Categoría " + categoryId);
		Category category = categoryService.getCategoryByCategoryId(categoryId);
		return category;
	}

}

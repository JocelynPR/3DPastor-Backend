package com.pokemonplace.app.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pokemonplace.app.entity.Category;
import com.pokemonplace.app.entity.Image;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductDto {
	
	private Long id;
	private String title;
	private float price;
	@JsonIgnoreProperties("categoryId")
	private Category category;
	private Long availableQty;
	@JsonIgnoreProperties({"imageId", "product", "active"})
	private List<Image> image;

}

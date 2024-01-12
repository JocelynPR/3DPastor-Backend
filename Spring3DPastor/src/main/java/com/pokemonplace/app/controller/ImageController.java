package com.pokemonplace.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.Image;
import com.pokemonplace.app.service.ImageService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/images")
@Log4j2
public class ImageController {
	
	@Autowired
	ImageService imageService;
	
	@GetMapping("{imageId}")
	Image getImageByImageId(@PathVariable(name="imageId") Long imageId) {
		log.info("Datos del Id de Imagen " + imageId);
		Image image = imageService.getImageByImageId(imageId);
		return image;
	}
	
	@PostMapping
	Image setImage(@RequestBody Image image) {
		log.info("Agregando imagen");
		log.info(image);
		Image newImage = imageService.createImage(image);
		return newImage;
	}
	
	@GetMapping("query")
	Image getImageByImageName(@RequestParam(name= "imageName") String imageName) {
		return imageService.getImageByImageName(imageName);
	}
	
	@PutMapping("{imageId}")
	Image updateImage(@RequestBody Image image, @PathVariable("imageId") Long imageId) {
		return imageService.updateImage(image, imageId);
	}
	
	@DeleteMapping("{imageId}")
	String deleteImage(@PathVariable("imageId") Long imageId) {
		imageService.deleteImage(imageId);
		return "Se eliminó la imagen con el id " + imageId;
	}

}

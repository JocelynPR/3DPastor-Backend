package com.pokemonplace.app.service;

import com.pokemonplace.app.entity.Image;

public interface ImageService {
	
	Image getImageByImageId(Long imageId);
	Image getImageByImageName(String imageName);
	Image createImage(Image image);
	Image updateImage(Image image, Long imageId);
	void deleteImage(Long imageId);
	void deactivateImage(Long imageId);
}

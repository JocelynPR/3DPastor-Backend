package com.pokemonplace.app.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pokemonplace.app.entity.Image;
import com.pokemonplace.app.repository.ImageRepository;
import com.pokemonplace.app.service.ImageService;

@Service
public class ImageServiceImp implements ImageService {
	
	@Autowired
	ImageRepository imageRepository;

	@Override
	public Image getImageByImageId(Long imageId) {
		Optional<Image> imageOptional = imageRepository.findById(imageId);
		if( imageOptional.isPresent()) return imageOptional.get();
		else throw new IllegalStateException("Image Id not found " + imageId);
	}

	@Override
	public Image getImageByImageName(String imageName) {
		Optional<Image> imageOptional = imageRepository.findByImageName(imageName);
		if( imageOptional.isPresent()) return imageOptional.get();
		else throw new IllegalStateException("Image not found " + imageName);
	}

	@Override
	public Image createImage(Image image) {
		image.setImageId(null);
		Image newImage = imageRepository.save(image);
		return newImage;
	}

	@Override
	public Image updateImage(Image image, Long imageId) {
		Image existingImage = getImageByImageId(imageId);
		existingImage.setImageName(image.getImageName());
		existingImage.setProductId(image.getProductId());
		return imageRepository.save(existingImage);
	}

	@Override
	public void deleteImage(Long imageId) {
		Image existingImage = getImageByImageId(imageId);
		imageRepository.delete(existingImage);
		
	}

}

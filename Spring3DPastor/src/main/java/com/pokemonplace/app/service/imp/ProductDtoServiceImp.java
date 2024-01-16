package com.pokemonplace.app.service.imp;

import java.util.ArrayList;
import java.util.List;

import com.pokemonplace.app.dto.ProductDto;
import com.pokemonplace.app.entity.Product;
import com.pokemonplace.app.service.ProductDtoService;
import com.pokemonplace.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDtoServiceImp implements ProductDtoService {
	
	@Autowired
	ProductService productService;
	
	@Override
	public ProductDto getProductById(Long id) {
		Product product = productService.getProductById(id);
		return productToProductDto(product);
	}
	
	@Override
	public ProductDto getProductByTitle(String title) {
		Product product = productService.getProductByName(title);
		return productToProductDto(product);
	}
	
	@Override
	public ProductDto createProduct(Product product) {
		Product newProduct = productService.createProduct(product);
		return productToProductDto(newProduct);
	}
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> products = productService.getAllProducts();
		List<ProductDto> productsDto = new ArrayList<>();
		for(Product product : products) {
			productsDto.add(productToProductDto(product));
		}
		return productsDto;
	}
	
	@Override
	public ProductDto updateProduct(Product product, Long id) {
		Product updatedProduct = productService.updateProduct(product, id);
		return productToProductDto(updatedProduct);
	}
	
	@Override
	public void deleteProduct(Long id) {
		productService.deactivateProduct(id);
	}
	
	private ProductDto productToProductDto(Product product) {
		ProductDto productDto = new ProductDto();
		productDto.setId(product.getId());
		productDto.setTitle(product.getNameProduct());
		productDto.setPrice(product.getPrice());
		productDto.setCategory(product.getCategory());
		productDto.setAvailableQty(product.getQty());
		productDto.setImage(product.getImages());
		return productDto;
	}

}

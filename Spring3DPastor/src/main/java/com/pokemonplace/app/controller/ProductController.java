package com.pokemonplace.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.pokemonplace.app.entity.Category;
import com.pokemonplace.app.entity.Product;
import com.pokemonplace.app.service.ProductService;
import com.pokemonplace.app.service.CategoryService;

import lombok.extern.log4j.Log4j2;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1/products")
@Log4j2
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping
    List<Product> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return products;
    }

    @GetMapping("{id}")
    Product getProductById(@PathVariable(name = "id") Long id) {
        log.info("Datos del Id " + id);
        Product product = productService.getProductById(id);
        return product;
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestParam(name = "categoryId") Long categoryId) {
        // Verifica que la categoría exista antes de asignarla al producto
        Category category = categoryService.getCategoryByCategoryId(categoryId);
        if (category == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        // Asigna la categoría al producto
        product.setCategory(category);

        // Guarda el producto en la base de datos
        Product newProduct = productService.createProduct(product);

        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping("query")
    Product getProductByName(@RequestParam(name = "nameProduct") String name) {
        return productService.getProductByName(name);
    }

    @PutMapping("{id}")
    Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id) {
        return productService.updateProduct(product, id);
    }

    @PutMapping("{id}/deactivate")
    String deactivateProduct(@PathVariable("id") Long id) {
        productService.deactivateProduct(id);
        return "Se desactivó el producto con id " + id;
    }
}

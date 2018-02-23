package com.example.springboot.intro.product;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable("id") Long id) {
		productService.deleteProduct(id);
	}

	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") Long id) {
		return productService.getProduct(id);
	}

	@GetMapping
	public List<Product> getProducts() {
		return productService.getProducts();
	}

	@PostMapping
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
}

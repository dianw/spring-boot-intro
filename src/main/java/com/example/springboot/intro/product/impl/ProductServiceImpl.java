package com.example.springboot.intro.product.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.intro.product.Product;
import com.example.springboot.intro.product.ProductRepository;
import com.example.springboot.intro.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private final ProductRepository productRepository;

	public ProductServiceImpl(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@Override
	public void deleteProduct(Long id) {
		productRepository.delete(id);
	}

	@Override
	public Product getProduct(Long id) {
		return productRepository.findOne(id);
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}
}

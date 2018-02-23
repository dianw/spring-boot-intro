package com.example.springboot.intro.product.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.example.springboot.intro.product.Product;
import com.example.springboot.intro.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	private Map<Long, Product> products = new ConcurrentHashMap<>();
	private AtomicLong atomicLong = new AtomicLong();

	@Override
	public void deleteProduct(Long id) {
		products.remove(id);
	}

	@Override
	public Product getProduct(Long id) {
		return products.get(id);
	}

	@Override
	public List<Product> getProducts() {
		return new ArrayList<>(products.values());
	}

	@Override
	public Product saveProduct(Product product) {
		product.setId(atomicLong.incrementAndGet());
		products.put(product.getId(), product);
		return products.get(product.getId());
	}
}

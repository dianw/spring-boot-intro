package com.example.springboot.intro.product;

import java.util.List;

public interface ProductService {
	void deleteProduct(Long id);

	Product getProduct(Long id);

	List<Product> getProducts();

	Product saveProduct(Product product);
}

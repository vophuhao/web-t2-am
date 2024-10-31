package vn.iostar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.iostar.entity.Category;
import vn.iostar.entity.Product;


public interface IProductService {

	List<Product> findAll();

	

	<S extends Product> S save(S entity);

	Optional<Product> getProductByProductId(String productId);
	
	Optional<Product> findById(Long id);

}

package vn.iostar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import vn.iostar.entity.Category;


public interface ICategoryService {

	List<Category> findAll();

	

	<S extends Category> S save(S entity);

	Optional<Category> getCategoryByCategoryId(String categoryId);
	
	Optional<Category> findById(Long id);


}

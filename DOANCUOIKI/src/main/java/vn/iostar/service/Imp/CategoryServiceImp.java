package vn.iostar.service.Imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.entity.Category;
import vn.iostar.repository.CategoryRepository;
import vn.iostar.service.ICategoryService;

@Service
public class CategoryServiceImp implements ICategoryService
{
	@Autowired 
	CategoryRepository categoryRepository;

	public CategoryServiceImp(CategoryRepository categoryRepository) {
	
		this.categoryRepository = categoryRepository;
	}
	
	@Override
	public List <Category> findAll() { 
		
		return categoryRepository.findAll();
	}
	

}

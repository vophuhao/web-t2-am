package vn.iostar.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

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
	
	@Override
	public <S extends Category> S save(S entity) {
	if(entity.getCategoryId() == null) {
		return categoryRepository.save(entity);
		}
	else {
		Optional<Category> opt =getCategoryByCategoryId(entity.getCategoryId());
		if(opt.isPresent()) {
		if (StringUtils.isEmpty(entity.getCategoryName())) {
			entity.setCategoryName(opt.get().getCategoryName());
		}
		else {
		//lấy lại images cũ www
		entity.setCategoryName(entity.getCategoryName());
		}
		
		}
		return categoryRepository.save(entity);
		}
	}
	@Override
	public Optional<Category> getCategoryByCategoryId(String categoryId) {
	    return categoryRepository.findByCategoryId(categoryId);
	            
	}
	
	@Override
	public Optional<Category> findById(Long id) {
		return categoryRepository.findById(id);
	}
}

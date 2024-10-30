package vn.iostar.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

	 Optional<Category> findByCategoryId(String categoryId);

	

	
	
}

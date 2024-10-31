package vn.iostar.repository;



import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.iostar.entity.Category;
import vn.iostar.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	 Optional<Product> findByProductId(String productId);

	

	
	
}

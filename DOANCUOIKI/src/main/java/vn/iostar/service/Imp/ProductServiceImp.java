package vn.iostar.service.Imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.iostar.entity.Product;
import vn.iostar.repository.ProductRepository;
import vn.iostar.service.IProductService;


@Service
public class ProductServiceImp implements IProductService
{
	@Autowired 
	ProductRepository productRepository;

	public ProductServiceImp(ProductRepository productRepository) {
	
		this.productRepository = productRepository;
	}
	
	@Override
	public List <Product> findAll() { 
		
		return productRepository.findAll();
	}
	
	@Override
	public <S extends Product> S save(S entity) {
		return productRepository.save(entity);
	}
	@Override
	public Optional<Product> getProductByProductId(String productId) {
	    return productRepository.findByProductId(productId);
	            
	}
	
	@Override
	public Optional<Product> findById(Long id) {
		return productRepository.findById(id);
	}
}

package vn.iostar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import vn.iostar.entity.Category;

@Service
public interface ICategoryService {

	List<Category> findAll();

}

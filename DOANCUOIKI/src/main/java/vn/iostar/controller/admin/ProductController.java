package vn.iostar.controller.admin;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import vn.iostar.entity.Category;
import vn.iostar.entity.Product;
import vn.iostar.service.ICategoryService;
import vn.iostar.service.IProductService;


@Controller
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
	IProductService productService;
	@Autowired
	ICategoryService categoryService;
	@RequestMapping("")
	public String listProduct(ModelMap model)
	{
		List<Product> list=productService.findAll();
		System.out.print(list);
		model.addAttribute("products", list);
	
		return "admin/product-list1";
	}

	@GetMapping("/add")
	public  String addProduct(ModelMap model) {
		
	    List<Category> categories = categoryService.findAll();
	    
	    // Add the list of categories to the model
	    model.addAttribute("categories", categories);
		return "admin/add-product";
	}
	@PostMapping("/save")
	public String add(@Valid Product product, BindingResult result, Model model, @RequestParam("categoryId") Long categoryId) {
		
		Optional<Category> category = categoryService.findById(categoryId);
		Category category1 = category.orElseThrow(() -> 
	    new IllegalArgumentException("Invalid category ID: " + categoryId));

		product.setCategory(category1);
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	// Mun 53 - 78
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, ModelMap model) {
		Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
	    List<Category> categories = categoryService.findAll();

	    // Add the list of categories to the model
	    model.addAttribute("categories", categories);
		model.addAttribute("product", product);
		return "admin/edit-product";
	}

	@PostMapping("/update")
	public String update(@Valid Product product, BindingResult result, Model model,@RequestParam("categoryId") Long categoryId) {
		if (result.hasErrors()) {
			return "admin/home";
		}
		Optional<Category> category = categoryService.findById(categoryId);
		Category category1 = category.orElseThrow(() -> 
	    new IllegalArgumentException("Invalid category ID: " + categoryId));

		product.setCategory(category1);
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/productdetail")
	public String productDetail()
	{
		return "admin/product-detail";
	}
}

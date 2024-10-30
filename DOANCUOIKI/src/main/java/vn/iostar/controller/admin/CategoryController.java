package vn.iostar.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import vn.iostar.entity.Category;
import vn.iostar.service.ICategoryService;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	
	@Autowired
	ICategoryService categoryService;
	@RequestMapping("")
	public String listCategory(ModelMap model)
	{
		List<Category> list=categoryService.findAll();
		model.addAttribute("categories", list);
		System.out.print(list);
		return "admin/category-list";
	}

	@GetMapping("/add")
	public  String addCategory() {
		
		
		return "admin/add-category";
	}
	
}

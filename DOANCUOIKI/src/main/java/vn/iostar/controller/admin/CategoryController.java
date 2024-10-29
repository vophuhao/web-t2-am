package vn.iostar.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/admin/categories")
public class CategoryController {
	
	
	@RequestMapping("")
	public String listCategory()
	{
		return "admin/category-list";
	}

	@GetMapping("/add")
	public  String addCategory() {
		
		return "admin/add-category";
	}
	
}

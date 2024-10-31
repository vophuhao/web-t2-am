package vn.iostar.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ch.qos.logback.core.model.Model;
import jakarta.validation.Valid;
import vn.iostar.entity.Product;
import vn.iostar.service.IProductService;


@Controller
@RequestMapping("/admin/products")
public class ProductController {
	
	@Autowired
	IProductService productService;
	@RequestMapping("")
	public String listProduct(ModelMap model)
	{
		List<Product> list=productService.findAll();
		System.out.print(list);
		model.addAttribute("products", list);
	
		return "admin/product-list1";
	}

	@GetMapping("/add")
	public  String addProduct() {
		
		return "admin/add-product";
	}
	@PostMapping("/save")
	public String add(@Valid Product product, BindingResult result, Model model,RedirectAttributes redirectAttributes) {
		/*
		 * System.out.print(product); if (result.hasErrors()) { return
		 * "redirect:/admin/categories"; }
		 */
		 redirectAttributes.addFlashAttribute("successMessage", "product saved successfully!");
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	// Mun 53 - 78
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") long id, ModelMap model) {
		Product product = productService.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		model.addAttribute("product", product);
		return "admin/edit-product";
	}

	@PostMapping("/update")
	public String update(@Valid Product product, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "admin/home";
		}
		productService.save(product);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/productdetail")
	public String productDetail()
	{
		return "admin/product-detail";
	}
}

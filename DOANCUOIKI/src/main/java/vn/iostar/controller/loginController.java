package vn.iostar.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/login")
public class loginController {

	@GetMapping
	public String LoginPage()
	{
		return "/login.html";
		
	}
}

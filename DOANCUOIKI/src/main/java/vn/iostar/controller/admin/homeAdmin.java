package vn.iostar.controller.admin;



/*import org.springframework.security.access.prepost.PreAuthorize;*/
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller

public class homeAdmin {

	@RequestMapping(value="/admin/home" , method = RequestMethod.GET)
	public String HomePageAdmin()
	{
		return "admin/home";
		
	}
		
}

package com.heraizen.aop.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebServiceControllerController {

	@RequestMapping(value="/index",method = RequestMethod.GET)
	public String index(Model model)
	{
		
		List<User> use = new ArrayList<>();
		
		User u1 = User.builder().name("boobalan").email("boobalanv2016@gmail").mobile("7200212302").build();
		User u3 = User.builder().name("Shankar").email("shankar@gmail").mobile("9876543210").build();
		User u2 = User.builder().name("Ranjith").email("ranjith@gmail").mobile("1234567890").build();
	use.add(u1);
	use.add(u2);
	use.add(u3);
		
	model.addAttribute("users", use);
	
	return "index";
	
	}
	
	
	
}

package edu.mum.coffee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/index", "/home"})
	public String homePage() {
		return "welcome";
	}

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	
	/*@GetMapping({"/products"})
	public String personApi(){
		return "products";
	}*/
}

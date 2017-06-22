package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String products(Model model){
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public String createProduct(Product product){
		productService.save(product);
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/products/{id}/delete", method = RequestMethod.POST)
	public String deleteProduct(@PathVariable int id){
		Product product = productService.getProduct(id);
		productService.delete(product);
		return "redirect:/products";
	}
}

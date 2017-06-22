package edu.mum.coffee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String getOrders(Model model){
		model.addAttribute("orders", orderService.findAll());
		return "orders";
	}
	
	@RequestMapping(value = "/orders", method = RequestMethod.POST)
	public String createOrder(@RequestBody Order order){
		orderService.save(order);
		return "orders";
	}
	
	@RequestMapping(value = "/orders/{id}", method = RequestMethod.DELETE)
	public String deleteOrder(@PathVariable String id){
		Order order = orderService.findById(Integer.parseInt(id));
		orderService.delete(order);
		return "orders";
	}

}

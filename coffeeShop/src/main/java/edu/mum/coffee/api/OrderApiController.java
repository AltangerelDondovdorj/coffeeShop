package edu.mum.coffee.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.coffee.domain.Order;
import edu.mum.coffee.service.OrderService;

@Controller
public class OrderApiController {
	
	@Autowired
	OrderService orderService;
	
	 // -------------------Retrieve All Orders---------------------------------------------
	 
    @RequestMapping(value = "/api/order", method = RequestMethod.GET, produces={"application/json"})
    public @ResponseBody ResponseEntity<List<Order>> listAllOrders() {
        return new ResponseEntity<List<Order>>(orderService.findAll(), HttpStatus.OK);
    }

	// --------------Create/Update person -----------//
	@RequestMapping(value = "/api/order", method = RequestMethod.POST)
	 public @ResponseBody ResponseEntity<?> createOrder(@RequestBody Order order, UriComponentsBuilder ucBuilder) {
		
        orderService.save(order);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
        
    }
	
	// --------------Delete person -----------//
	@RequestMapping(value = "/api/order/{id}", method = RequestMethod.DELETE)
	 public @ResponseBody ResponseEntity<?> updateOrder(@PathVariable("id") int id) {
       
       Order order = orderService.findById(id);
       
       if(order != null ) {
    	   orderService.delete(order);
    	   return new ResponseEntity<Boolean>(true, HttpStatus.OK);
       }
       
       return new ResponseEntity<Boolean>(false, HttpStatus.NO_CONTENT);
   }
}

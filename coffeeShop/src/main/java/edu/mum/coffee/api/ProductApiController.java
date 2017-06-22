package edu.mum.coffee.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.UriComponentsBuilder;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;

@Controller
public class ProductApiController {
	
	@Autowired
	ProductService productService;
	
	 // -------------------Retrieve All Product---------------------------------------------
    @RequestMapping(value = "/api/product", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<List<Product>> listAllProducts(Model model) {
    	
        List<Product> products = productService.getAllProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
        
    }

	// --------------Create product -----------//
	@RequestMapping(value = "/api/product", method = RequestMethod.POST)
	 public @ResponseBody ResponseEntity<?> createProduct(@RequestBody Product product, UriComponentsBuilder ucBuilder) {
        
        productService.save(product);
        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
	
	// --------------Delete product -----------//
	@RequestMapping(value = "/api/product/{id}", method = RequestMethod.DELETE)
	 public @ResponseBody ResponseEntity<?> updatePerson(@PathVariable("id") int productId) {
       
       Product product = productService.getProduct(productId);
       productService.delete(product);
       return new ResponseEntity<Boolean>(true, HttpStatus.OK);
   }
}

package com.model2.mvc.web.product;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.domain.User;
import com.model2.mvc.service.product.ProductService;


@RestController
@RequestMapping("/product/*")
public class ProductRestController {

	///Field
		@Autowired
		@Qualifier("productServiceImpl")
		private ProductService productService;
		//setter Method 구현 않음
		
		public ProductRestController(){
			System.out.println(this.getClass());
		}
		
		@RequestMapping( value="json/getProduct/{prodNo}", method=RequestMethod.GET )
		public Product getProduct( @PathVariable int prodNo ) throws Exception{
			
			System.out.println("/product/json/getProduct : GET");
			
			//Business Logic
			return productService.getProduct(prodNo);
		}
		
		@RequestMapping( value="json/addProduct", method=RequestMethod.POST )
		public Product addProduct( @RequestBody Product product) throws Exception{
			
			System.out.println("/product/json/addProduct : POST");
			
			//Business Logic
			productService.addProduct(product);
			
			return product;
		}
		
		@RequestMapping( value="json/updateProduct", method=RequestMethod.POST )
		public Product updateProduct( @RequestBody Product product) throws Exception{
			
			System.out.println("/product/json/updateProduct : POST");
			
			//Business Logic
			productService.updateProduct(product);
			
			return product;
		}
		
		
		
}

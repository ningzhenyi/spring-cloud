package com.nzy.book.product.facade;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nzy.book.product.domain.Product;

@RequestMapping("/product")
public interface ProductFacade {

	@RequestMapping(value="list",method=RequestMethod.GET)
	public List<Product> listProduct();
	
	@RequestMapping(value="findAllProduct",method=RequestMethod.GET)
	public List<Product> getProduct();
	
	
	@RequestMapping(value="get",method=RequestMethod.GET)
	public Product getProduct(@RequestParam("id") Integer id);
	
	//---------------------------多参数------------------------------
	@RequestMapping(value="get1",method=RequestMethod.GET,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Product getProduct1(Product obj);
	
	@RequestMapping(value="get2",method=RequestMethod.GET)
	public Product getProduct2(@RequestParam("id") Integer id,@RequestParam("name") String name);
	
	//---------------------------post------------------------------
	@RequestMapping(value="add",method=RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_VALUE)
	public Product addProduct(@RequestBody Product obj);
}

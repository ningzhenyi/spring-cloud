package com.nzy.eureka.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.eureka.consumer.domain.Product;
import com.nzy.eureka.consumer.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<Product> listProduct() {
		return productService.listProduct();
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public Product get(Integer id) {
		return this.productService.get(id);
	}

	@RequestMapping(value = "/del", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public void del(Integer id) {
		this.productService.del(id);
	}
}

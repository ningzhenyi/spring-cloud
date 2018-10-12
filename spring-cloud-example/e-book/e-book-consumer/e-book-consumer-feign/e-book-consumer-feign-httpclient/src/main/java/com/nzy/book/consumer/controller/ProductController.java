package com.nzy.book.consumer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.book.consumer.service.ProductService;
import com.nzy.book.product.domain.Product;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<Product> listProduct() {
		return productService.getProduct();
	}

	@RequestMapping(value = "get", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public Product getProduct(@RequestParam("id") Integer id) {
		return productService.getProduct(id);
	}

	@RequestMapping(value = "get1", method = RequestMethod.GET)
	public Product getProduct1(Product obj) {
		return productService.getProduct1(obj);
	}
}

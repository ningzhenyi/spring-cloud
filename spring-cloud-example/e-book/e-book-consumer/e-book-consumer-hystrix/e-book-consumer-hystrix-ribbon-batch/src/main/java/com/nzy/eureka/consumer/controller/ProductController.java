package com.nzy.eureka.consumer.controller;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

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
	public void listProduct() throws InterruptedException, ExecutionException {
		Future<Product> f = productService.getproduct(1);
		Future<Product> f1 = productService.getproduct(2);
		Future<Product> f2 = productService.getproduct(3);
		Future<Product> f3 = productService.getproduct(4);
		System.out.println(f.get().toString());
		System.out.println(f1.get().toString());
		System.out.println(f2.get().toString());
		System.out.println(f3.get().toString());
	}
}

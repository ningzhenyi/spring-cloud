package com.nzy.eureka.provider.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.eureka.provider.domain.Product;

@RestController
public class ProductController {

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	public List<Product> getProduct() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "商品0000001"));
		list.add(new Product(2, "商品0000002"));
		list.add(new Product(3, "商品0000003"));
		list.add(new Product(4, "商品0000004"));
		list.add(new Product(5, "商品0000005"));
		list.add(new Product(6, "商品0000006"));
		return list;
	}
}

package com.nzy.book.consumer.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nzy.book.consumer.hystrix.ProductServiceFallback;
import com.nzy.book.product.domain.Product;

@FeignClient(name = "e-book-product-core", fallbackFactory = ProductServiceFallback.class)
public interface ProductService {

	@RequestMapping(value = "/product/list", method = RequestMethod.GET, produces = {
			"application/json;charset=UTF-8" })
	public List<Product> getProduct();
}

package com.nzy.book.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nzy.book.consumer.service.ProductService;
import com.nzy.book.product.domain.Product;

@Component
public class ProductServiceFallback implements ProductService {

	@Override
	public List<Product> getProduct() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(3, "fdsafdsafdsafsd"));
		return list;
	}

}

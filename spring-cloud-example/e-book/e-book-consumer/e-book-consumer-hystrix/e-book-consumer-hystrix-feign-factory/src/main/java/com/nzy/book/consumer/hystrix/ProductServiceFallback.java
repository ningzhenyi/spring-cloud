package com.nzy.book.consumer.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.nzy.book.consumer.service.ProductService;
import com.nzy.book.product.domain.Product;

import feign.hystrix.FallbackFactory;

@Component
public class ProductServiceFallback implements FallbackFactory<ProductService> {

	private Logger logger = LoggerFactory.getLogger(ProductServiceFallback.class);

	@Override
	public ProductService create(final Throwable cause) {
		return new ProductService() {

			@Override
			public List<Product> getProduct() {
				logger.warn("fallback exception:", cause);
				List<Product> list = new ArrayList<Product>();
				list.add(new Product(3, "fdsafdsafdsafsd"));
				return list;
			}
		};
	}

}

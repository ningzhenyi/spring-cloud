package com.nzy.book.consumer.service;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.nzy.book.product.facade.ProductFacade;

@FeignClient(name="e-book-product-core")
public interface ProductService extends ProductFacade {

}

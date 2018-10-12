package com.nzy.eureka.book.product.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.nzy.book.product.domain.Product;
import com.nzy.book.product.facade.ProductFacade;
import com.nzy.eureka.book.product.service.ProductService;

@RestController
public class ProductFacadeImpl implements ProductFacade {

	@Autowired
	private ProductService productService;
	
	@Override
	public List<Product> listProduct() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return  this.productService.findAllProduct();
	}

	@Override
	public List<Product> getProduct() {
		return this.productService.findAllProduct();
	}

	@Override
	public Product getProduct(Integer id) {
		return this.productService.getProduct(id);
	}

	@Override
	public Product getProduct1(Product obj) {
		return obj;
	}

	@Override
	public Product getProduct2(Integer id, String name) {
		return new Product(id,name);
	}

	@Override
	public Product addProduct(Product obj) {
		return obj;
	}
}

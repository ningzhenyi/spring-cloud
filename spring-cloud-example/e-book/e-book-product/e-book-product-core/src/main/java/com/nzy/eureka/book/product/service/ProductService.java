package com.nzy.eureka.book.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nzy.book.product.domain.Product;
import com.nzy.eureka.book.product.persistence.ProductMapper;

@Service
public class ProductService {
	
	@Autowired
	private ProductMapper productMapper;
	
	public List<Product> findAllProduct(){
		return  this.productMapper.findAllProduct();
	}
	public List<Product> listProduct(){
		return  this.productMapper.findAllProduct();
	}

	public Product getProduct(Integer id) {
		return this.productMapper.selectByPrimaryKey(id);
	}
}

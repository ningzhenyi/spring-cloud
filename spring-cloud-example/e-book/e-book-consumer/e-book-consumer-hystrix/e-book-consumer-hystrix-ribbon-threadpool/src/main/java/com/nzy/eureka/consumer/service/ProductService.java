package com.nzy.eureka.consumer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.nzy.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@HystrixCommand(groupKey = "e-book-product-core", commandKey = "listProduct", threadPoolKey = "e-book-product-core", threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "30"), // 线程池大小
			@HystrixProperty(name = "maxQueueSize", value = "100"), // 最大队列长度
			@HystrixProperty(name = "keepAliveTimeMinutes", value = "2"), // 线程存活时间
			@HystrixProperty(name = "queueSizeRejectionThreshold", value = "15")// 拒绝请求
	}, fallbackMethod = "fallback")
	public List<Product> listProduct() {
		System.out.println("########################################");
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		ServiceInstance si = loadBalancerClient.choose("e-book-product-core");
		StringBuffer sb = new StringBuffer();
		sb.append("http://");
		sb.append(si.getHost());
		sb.append(":");
		sb.append(si.getPort());
		sb.append("/product/list");

		RestTemplate temp = new RestTemplate();
		ParameterizedTypeReference<List<Product>> typeRef = new ParameterizedTypeReference<List<Product>>() {
		};
		ResponseEntity<List<Product>> re = temp.exchange(sb.toString(), HttpMethod.GET, null, typeRef);
		List<Product> list = re.getBody();
		System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return list;
	}

	public List<Product> fallback() {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "和理解是否建立"));
		return list;
	}
}

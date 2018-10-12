package com.nzy.eureka.consumer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Future;

import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.HystrixCollapser.Scope;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.conf.HystrixPropertiesManager;
import com.nzy.eureka.consumer.domain.Product;

@Service
public class ProductService {

	@Autowired
	private LoadBalancerClient loadBalancerClient;

	@HystrixCollapser(batchMethod = "batchProduct", scope = Scope.GLOBAL, collapserProperties = {
			@HystrixProperty(name = "timerDelayInMilliseconds", value = "20"),
			@HystrixProperty(name = "maxRequestsInBatch", value = "200") })
	public Future<Product> getproduct(Integer id) {
		return null;
	}

	@HystrixCommand(fallbackMethod = "fallback", commandProperties = {
			@HystrixProperty(name = HystrixPropertiesManager.FALLBACK_ISOLATION_SEMAPHORE_MAX_CONCURRENT_REQUESTS, value = "20") })
	public List<Product> batchProduct(List<Integer> ids) {
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

	public List<Product> fallback(List<Integer> ids) {
		List<Product> list = new ArrayList<Product>();
		list.add(new Product(1, "漫谈spring cloud与spring boot基础架构（微服务基础篇）"));
		list.add(new Product(2, "漫谈spring cloud分布式服务架构（微服务进阶篇）"));
		list.add(new Product(3, "漫谈spring cloud 与docker架构部署（微服务高级篇）"));
		list.add(new Product(4, "444444444444444444"));
		return list;
	}
}

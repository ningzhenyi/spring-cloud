package com.nzy.book.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class AccessFilter extends ZuulFilter {

	private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext rc = RequestContext.getCurrentContext();
		HttpServletRequest request = rc.getRequest();
		String token = request.getParameter("token");
		if (token == null) {
			logger.warn("token is null");
			rc.setSendZuulResponse(false);
			rc.setResponseStatusCode(300);
			rc.setResponseBody("{\"result\" : \"token is null\"}");
			rc.getResponse().setContentType("text/html");
		} else {
			logger.info("token is ok");
		}
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

}

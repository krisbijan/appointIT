package com.krisbijan.zuulapigateway;

import java.io.IOException;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class LoggingFilterPre extends ZuulFilter {

	private final Logger LOGGER = LoggerFactory.getLogger("loggerPre");

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		LOGGER.info("request uri -> {}", request.getRequestURI());

		if ("POST".equalsIgnoreCase(request.getMethod()) || "PUT".equalsIgnoreCase(request.getMethod())) {
			String body="";
			try {
				body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			LOGGER.info(request.getMethod()+" request body -> {}", body);
		} else
			LOGGER.info(request.getMethod()+" request");
		
	    String appUrl = request.getScheme() + "://"+ request.getLocalAddr();
		LOGGER.info("Client IP -> {}",appUrl);
		LOGGER.info("________________________________________");
		return null;
	}

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}

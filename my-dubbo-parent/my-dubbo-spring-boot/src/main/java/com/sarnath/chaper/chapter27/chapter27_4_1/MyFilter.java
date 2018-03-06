package com.sarnath.chaper.chapter27.chapter27_4_1;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * 注册自定义Filter的方式二。
 * 注：此方式需要在App启动类中添加@ServletComponentScan注解
 * 
 * 注册的代码在ConfigurationForRegist.java中
 * @author OM
 *
 */
@WebFilter(filterName="filter1", urlPatterns="/registCustomerFilterMethod2/*") 
public class MyFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("自定义Filter，访问registCustomerFilterMethod1或者registCustomerFilterMethod2时成功被Filter拦截");
		chain.doFilter(request, response);  
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}

	

}

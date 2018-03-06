package com.sarnath.chaper.chapter27.chapter27_4_1;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 27.4.1 Servlets, Filters, and listeners
 * 
 * 此类用于自定义注册Servlet
 * @author OM
 *
 */
@Configuration
public class ConfigurationForRegist {
	/**
	 * 通过Spring bean方式注册一个Servlet（方式一）。
	 * http://localhost:8089/customer访问后，便可以调用我们自定义的RegistServlet类中的
	 * 使用方式二，就不需要此处的@Bean，及其方法了。
	 * 
	 * 
	 * 通过注解形式（方式二）
	 * 在Servlet（RegistServlet.java)类上添加 @WebServlet(urlPatterns = "/b")注解
	 * 然后在App.java类上添加@ServletComponentScan注解来扫描
	 * @return
	 */
	@Bean
	public ServletRegistrationBean registCustomerServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new MyServlet());
		registration.addUrlMappings("/registCustomerServletMethod1");
		return registration;
	}
	
	/**
	 * 添加一个自定义Filter和Servlet是相同的
	 * 
	 * 访问http://localhost:8089/registCustomerServletMethod1时会被此Filter拦截，
	 * 如果访问其他的例如http://localhost:8089/registCustomerServletMethod2则不会被此Filter拦截
	 * @return
	 */
	@Bean  
    public FilterRegistrationBean registCustomerFilter() {  
        FilterRegistrationBean myFilter = new FilterRegistrationBean();  
        myFilter.addUrlPatterns("/registCustomerFilterMethod1/*");  
        myFilter.setFilter(new MyFilter());  
        return myFilter;  
    }  
	
	/**
	 * 注册自定义Listener方式一（Spring bean方式）
	 * @return
	 */
	@Bean
	public ServletListenerRegistrationBean registCustomerListener() {
		 ServletListenerRegistrationBean<MyListener> myListener = new ServletListenerRegistrationBean<MyListener>();  
	        myListener.setListener(new MyListener());  
	        return myListener;  
	}
}

package com.sarnath.chaper.chapter27.chapter27_4_2;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

import com.sarnath.chaper.chapter27.chapter27_4_1.MyFilter;

/**
 * 27.4.2 Servlet Context Initialization
 * 
 * 通过实现ServletContextInitializer 接口，可以获取servletContext中的内容，并且可以通过这种方式在程序启动时，动态注册Filter，Servlet，Listener
 * @author OM
 *
 */
@Configuration
public class ServletContextInitialization implements ServletContextInitializer  {
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		//动态注册了一个Filter。注册后，访问url“/registFilterFromServletContextInitialization”的请求，会被Filter拦截
		FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/registFilterFromServletContextInitialization");
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceEncoding", "true");

		System.out.println("Servlet Context Initialization类的onStartup方法被调用");
	}
}

/*除了上面的实现ServletContextInitializer接口方式外，还可以使用实现WebApplicationInitializer接口方式
 * public class WebInitializer implements WebApplicationInitializer {    
    public void onStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException {  
        // Filter  
    	FilterRegistration.Dynamic filter = servletContext.addFilter("encodingFilter", MyFilter.class);
		filter.addMappingForUrlPatterns(null, false, "/registFilterFromServletContextInitialization");
		filter.setInitParameter("encoding", "UTF-8");
		filter.setInitParameter("forceEncoding", "true");

		System.out.println("Servlet Context Initialization类的onStartup方法被调用");

    }  
} */ 

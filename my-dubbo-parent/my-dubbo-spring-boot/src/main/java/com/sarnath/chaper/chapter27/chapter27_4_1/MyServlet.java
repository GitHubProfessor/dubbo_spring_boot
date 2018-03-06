package com.sarnath.chaper.chapter27.chapter27_4_1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 27.4.1 自定义Servlet方式二，配置方式。
 * 使用此方式就不需要使用ServletRegistrationBean中的@Bean注册了。
 * 二者选一即可
 * 
 * 注：此方式需要在App启动类中添加@ServletComponentScan注解
 * 
 * 注册的代码在ConfigurationForRegist.java中
 * @author OM
 *
 */
@WebServlet(urlPatterns = "/registCustomerServletMethod2")
public class MyServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	   @Override
	    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("doGet");
	        doPost(req, resp);
	    }

	    @Override
	    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	        System.out.println("doPost()");
	        resp.setContentType("text/html");
	        resp.setCharacterEncoding("utf-8");
	        PrintWriter out = resp.getWriter();
	        out.println("<h1>chapter27.4.1 spring boot 注册自定义Servelet</h1>");
	    }
}

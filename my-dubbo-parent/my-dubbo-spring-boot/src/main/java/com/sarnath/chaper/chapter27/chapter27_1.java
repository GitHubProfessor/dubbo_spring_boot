package com.sarnath.chaper.chapter27;


import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 27.1 The “Spring Web MVC Framework”
 * 
 * 访问 http://localhost:8089/users/1  进入
 * 
 * @author OM
 *
 */
@RestController
@RequestMapping(value="/users")
public class chapter27_1 {
	@RequestMapping(value="/{user}", method=RequestMethod.GET)
	public void getUser(@PathVariable Long user) {
		String str = String.format("@PathVariable user :%s", user);
		System.out.println("@PathVariable user :" + user);
	}

	@RequestMapping(value="/{user}/customers", method=RequestMethod.GET)
	void getUserCustomers(@PathVariable Long user) {
		System.out.println("@PathVariable user :" + user);
	}

	@RequestMapping(value="/{user}", method=RequestMethod.DELETE)
	public void deleteUser(@PathVariable Long user) {
		System.out.println("@PathVariable user :" + user);
	}
	
	/**
	 * 27.1.11 Error Handling
	 * 此方法结合下面的方法，用来演示如果自定义错误信息
	 * 此方法抛出异常，然后会返回500错误码，然后下面的方法注册了500错误码对应的页面，
	 * 所以500错误都会用我们自定义的500.html页面来显示
	 */
	@RequestMapping(value="/errorpage", method=RequestMethod.GET)
	public void errorPage() {
		throw new RuntimeException();
	}
	
	/**
	 * 这个bean用来配置自定义错误页面的。上面errorpage报异常，返回状态码500后，
	 * 这个类便可以捕捉到500，然后跳转到指定的页面，显示自定义的500错误的页面
	 * @return
	 
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {

	   return (container -> {
	        ErrorPage error401Page = new ErrorPage(HttpStatus.UNAUTHORIZED, "/errorpage/401.html");
	        ErrorPage error404Page = new ErrorPage(HttpStatus.NOT_FOUND, "/errorpage/404.html");
	        ErrorPage error500Page = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/errorpage/500.html");

	        container.addErrorPages(error401Page, error404Page, error500Page);
	   });
	}*/
}


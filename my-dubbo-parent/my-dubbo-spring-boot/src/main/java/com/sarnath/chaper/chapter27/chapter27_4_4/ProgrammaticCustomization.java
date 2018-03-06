package com.sarnath.chaper.chapter27.chapter27_4_4;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
/**
 * 27.4.4 Customizing Embedded Servlet Containers
 * 
 * 通过编码来设置tomcat等container配置
 * 
 * 方法一：实现WebServerFactoryCustomizer接口，然后通过customize方法设置
 * 方法二：通过@Bean注册一个spring bean，然后在方法中设置。
 * 
 * 当感觉方法一有所局限时，可选择使用方法二。
 * 
 * 此类只有在spring boot2.0下才好用，当前是1.5.9.所以注释掉了
 *
 */
public class ProgrammaticCustomization implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>{

	/**
	 * 方法一
	 */
	@Override
	public void customize(ConfigurableServletWebServerFactory server) {
		server.setPort(9000);
	}
	
	
	/**
	 * 方法二
	 */
	@Bean
	public ConfigurableServletWebServerFactory webServerFactory() {
		TomcatServletWebServerFactory server = new TomcatServletWebServerFactory();
		Session session = new Session();
		session.setTimeout(Duration.ofHours(1));
		server.setPort(9000);
		server.setSession(session);
		server.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
		return server;
	}
}

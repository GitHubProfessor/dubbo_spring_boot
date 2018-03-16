package com.sarnath.chaper.chapter33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestTemplate时spring提供的一种在代码中直接通过方法调用http请求的方式。
 * 如果想使用RestTemplate，必须先通过RestTemplateBuilder来过去它。
 * 因为spring boot默认没有自动配置RestTemplate，而是自动配置了RestTemplateBuilder，所以需要RestTemplateBuilder来获取RestTemplate。
 * 在配置类中，像下面一样来配置，然后就可以在程序中通过@Autowired注解来注入RestTemplate了。
 * 
 * test包中chapter33介绍了如何注入使用。
 * @author OM
 *
 */
@Configuration
public class ConfigurationForRestTemplate {
	@Autowired
	private RestTemplateBuilder builder;

	@Bean
	public RestTemplate restTemplate() {
		return builder.build();
	}
}

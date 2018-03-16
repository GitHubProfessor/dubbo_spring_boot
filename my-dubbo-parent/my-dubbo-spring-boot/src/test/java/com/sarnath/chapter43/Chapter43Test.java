package com.sarnath.chapter43;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
 * 演示了43.3 Testing Spring Boot Applications中RANDOM_PORT的使用和意义
 *
 *
 *直接在测试类上面加上如下2个注解就能取到spring中的容器的实例，如果配置了@Autowired那么就自动将对象注入。
 *
 *@SpringBootTest(classes = {TestBeanConfiguration.class,Cat.class})在@SpringBootTest注解的参数classes中加入参数，表示将某些类纳入测试环境的容器中。
 *
 *单元测试环境下，springboot会只会读取到src/test/resources下的配置，
 *@SpringBootTest(properties = {"app.version=1.0"})通过这种方式获取properties文件中的value
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter43Test {
	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {
		String body = this.restTemplate.getForObject("/", String.class);
		System.out.println(body);
	}
	
	@Autowired
	private WebTestClient webClient;

	@Test
	public void exampleTest() {
		this.webClient.get().uri("/").exchange().expectStatus().isOk()
				.expectBody(String.class).isEqualTo("Hello World");
	}

}

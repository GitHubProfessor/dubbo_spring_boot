/**
 * 通过mock的方式来测试
 *  MockMvc是spring test子项目提供的，它通过建立一系列class去发送一个request请求到DispatcherServlet
 *  然后再断言返回结果是否正确
 *  
 *  使用@AutoConfigureMockMvc 和 @SpringBootTest来注入MockMvc实例的时候，将会创建整个工程的上下文。
 *  如果只想测试我们web layer（从页面到controller），那么我们就可以考虑使用AppTestIntegration这个类。
 */
package com.sarnath;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest：spring-projects/spring-test-htmlunit子项目中提供的用于页面自动化测试中的注解。
				//提供了Spring MVC测试框架、HtmlUnit、 WebDriver、Geb的集成测试，简化页面自动化测试，
				//利用这些技术可以完成无需启动服务器即可进行页面测试、自动化页面/页面流程测试、Javascript测试、Mock Service提高集成测试速度
public class AppTestMock {
	 	@Autowired
	    private MockMvc mvc;

	    @Test
	    public void getHello() throws Exception {
	        mvc.perform(MockMvcRequestBuilders
	        		.get("/health")
	        		.accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk())
	                .andExpect(content().string(equalTo("Greetings from Spring Boot!")));
	    }
}

package com.sarnath.chapter33;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

/**
 * 通过chapter33中的ConfigurationForRestTemplate.java配置后，便可以通过注入获取restTemplate了。
 * 然后就可以直接通过tempTemplate来调用rest方式的http，发起请求了。
 * @author OM
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RestTemplateTest {
	@Autowired
	private RestTemplate restTemplate;

    @Test
    public void getHello() throws Exception {
    	//此url是在spring_boot_demo中spring-boot-demo-ecache工程中发布的rest服务url。这里可以换成任何url
    	String url = "http://localhost:8080/api/select";
    	ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
    	System.out.println(result.getBody());
    }

}

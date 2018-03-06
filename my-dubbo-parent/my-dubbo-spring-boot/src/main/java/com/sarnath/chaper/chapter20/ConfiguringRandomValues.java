package com.sarnath.chaper.chapter20;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 24.1 Configuring random values
 * 可以再properties文件中通过${random.value}这种形式，将一个随机数复制给key，然后通过@Value可以获取到这个值。
 * 比如，密钥或测试用例这种方式很有用
 * 
 * 当将ConfiguringRandomValues注入到其他的类时，我们就可以获取到这个随机数的值了
 * @author liuhb
 *
 */
@Component
public class ConfiguringRandomValues {
	private String secret;
	public ConfiguringRandomValues(@Value("${my.secret}") String secret){
		this.secret = secret;
		System.out.println("从application properties文件中读取到的my.secret是 :" + secret);
	}
	
	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}
	 
} 

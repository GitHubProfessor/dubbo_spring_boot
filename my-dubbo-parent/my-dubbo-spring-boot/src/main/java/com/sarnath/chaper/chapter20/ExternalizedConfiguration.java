package com.sarnath.chaper.chapter20;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 24. Externalized Configuration
 * 通过spring实例化此对象是，将properties文件中key为server.port的值，注入到port字段
 * 
 * @author liuhb
 *
 */
@Component
public class ExternalizedConfiguration {
	
	private String port;

	public ExternalizedConfiguration(@Value("${server.port}") String port){
		this.port = port;
		System.out.println("从application properties文件中读取到的server.port 是:" + port);
	}
	
	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}
}

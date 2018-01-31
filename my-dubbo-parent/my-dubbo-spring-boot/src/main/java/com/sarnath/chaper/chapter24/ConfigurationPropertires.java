package com.sarnath.chaper.chapter24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 24.7章节 Type-safe Configuration Properties 实例
 * 
 * @ConfigurationProperties同时支持YAML和properties文件
 * @PropertySource只支持properties文件
 *
 */
@Component
@ConfigurationProperties(prefix = "myProps") // 接收application.yml中的myProps下面的属性
public class ConfigurationPropertires {
	//通过autowired可以直接获取到@Bean注解的bean，里面将带有yml的内容。此变量为24.7.1的例子
	//也就是说在任何地方，可以直接使用autowired注解获取到包含了yml文件中内容的bean
	@Autowired
	private ThirdPartBean thirdPartBean;
	
	private String simpleProp;
	private String[] arrayProps;
	private List<Map<String, String>> listProp1 = new ArrayList<>(); // 接收prop1里面的属性值
	private List<String> listProp2 = new ArrayList<>(); // 接收prop2里面的属性值
	private Map<String, String> mapProps = new HashMap<>(); // 接收prop1里面的属性值

	public String getSimpleProp() {
		return simpleProp;
	}

	// String类型的一定需要setter来接收属性值；maps, collections, 和 arrays 不需要
	public void setSimpleProp(String simpleProp) {
		this.simpleProp = simpleProp;
	}

	public List<Map<String, String>> getListProp1() {
		return listProp1;
	}

	public List<String> getListProp2() {
		return listProp2;
	}

	public String[] getArrayProps() {
		return arrayProps;
	}

	public void setArrayProps(String[] arrayProps) {
		this.arrayProps = arrayProps;
	}

	public Map<String, String> getMapProps() {
		return mapProps;
	}

	public void setMapProps(Map<String, String> mapProps) {
		this.mapProps = mapProps;
	}
	
	
	
	/**
	 * 24.7.1 Third-party configuration
	 * 通过两个注解，直接将yml中的内容，放入到此处模拟的第三方或者其他的bean中。
	 * 这样可以在使用autowired的时候，直接既可以得到带有yml中内容的bean了。
	 * @return
	 */
	@ConfigurationProperties(prefix = "myProps")
	@Bean
	public ThirdPartBean thridPartBean() {
		ThirdPartBean thirdPartBean = new ThirdPartBean();
	    return thirdPartBean;
	}
}

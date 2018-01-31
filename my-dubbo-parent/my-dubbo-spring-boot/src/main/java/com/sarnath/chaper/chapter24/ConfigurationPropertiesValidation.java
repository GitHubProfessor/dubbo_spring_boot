package com.sarnath.chaper.chapter24;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

/**
 * 24.7.4 @ConfigurationProperties Validation 实例
 * 
 * 通过实例发现，如果properties中的属性不符合bean中validate注解（@Max等）要求的，则会报错，实例的错误如下：
 * Binding to target com.sarnath.chaper.chapter24.ConfigurationPropertiesValidation@1ba4192b failed:
 * Property: target.threadPool
 * Value: 10
 * Reason: 最大不能超过5
 * 
 * @author OM
 *
 */
@Component
@PropertySource("classpath:ConfigurationPropertires.properties") // @PropertySource注解只能用于properties文件，不能用于yml文件
@ConfigurationProperties
@Validated
public class ConfigurationPropertiesValidation {
	@Max(5)
	@Min(0)
	private int threadPool;

	@NotEmpty
	private String email;

	public int getThreadPool() {
		return threadPool;
	}

	public void setThreadPool(int threadPool) {
		this.threadPool = threadPool;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}

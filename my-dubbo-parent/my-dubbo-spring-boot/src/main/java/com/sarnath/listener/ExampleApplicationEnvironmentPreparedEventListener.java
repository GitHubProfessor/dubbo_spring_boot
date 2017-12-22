package com.sarnath.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 采用META-INF下的spring.factories文件配置让spring boot自动添加监听事件
 * @author liuhb
 *
 */
public class ExampleApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

	@Override
	public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
		String[] argsStrings = event.getArgs();
		SpringApplication springApplication = event.getSpringApplication();
		System.out.println("ExampleApplicationEnvironmentPreparedEventListener is invoked...................");
	}

}

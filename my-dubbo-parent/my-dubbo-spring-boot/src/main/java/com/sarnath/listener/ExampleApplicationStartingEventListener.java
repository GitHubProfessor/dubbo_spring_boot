package com.sarnath.listener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * 采用META-INF下的spring.factories文件配置让spring boot自动添加监听事件
 *
 * @author liuhb
 *
 */
public class ExampleApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent > {

	@Override
	public void onApplicationEvent(ApplicationStartingEvent event) {
		String[] sources = event.getArgs();
		//获取到SpringApplication对象，可做一些执行前的设置.
		SpringApplication springApplication = event.getSpringApplication();
		System.out.println("ExampleApplicationStartingEventListener is invoked...............");
	}

}


package com.sarnath.listener;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * 该事件表示application应该初始化完成，可以准备接收请求,通过控制台可以看出，当tomcat启动后，就调用这个事件了 
 * 可以通过ApplicationReadyEvent获取ConfigurableApplicationContext，然后通过ConfigurableApplicationContext 获取bean的信息
 * @author liuhb
 *
 */
public class ExampleApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		System.out.println("ExampleApplicationReadyEventListener is invoked........");
	}

}

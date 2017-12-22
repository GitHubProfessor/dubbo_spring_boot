package com.sarnath.listener;

import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * spring boot启动异常时执行事件 
 * @author liuhb
 *
 */
public class ExampleApplicationFailedEventListener implements ApplicationListener<ApplicationFailedEvent> {

	@Override
	public void onApplicationEvent(ApplicationFailedEvent event) {
		System.out.println("ExampleApplicationFailedEventListener is invoked....................");
	}

}

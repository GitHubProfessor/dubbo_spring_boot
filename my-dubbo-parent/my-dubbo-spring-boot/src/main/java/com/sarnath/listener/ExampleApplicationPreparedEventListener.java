package com.sarnath.listener;

import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * 上下文创建完成后执行的事件监听器
 * @author liuhb
 *
 */
public class ExampleApplicationPreparedEventListener implements  ApplicationListener<ApplicationPreparedEvent>{

	@Override
	public void onApplicationEvent(ApplicationPreparedEvent event) {
		System.out.println("ExampleApplicationPreparedEventListener is invoked......");
		
	}

}

package com.sarnath;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * 官网23.7 Accessing application arguments
 * 读取传递给SpringApplication.run(…​)中的参数
 * 程序启动时，当spring构建这个类时，便会调用这个构造方法，然后把参数传进来
 */

@Component
public class AccessingApplicationArgumentsBean {
	 @Autowired
	    public AccessingApplicationArgumentsBean(ApplicationArguments args) {
	        boolean debug = args.containsOption("debug");
	        List<String> files = args.getNonOptionArgs();
	        // if run with "--debug logfile.txt" debug=true, files=["logfile.txt"]
	        System.out.println("AccessingApplicationArguments is invoked..............");
	    }
}

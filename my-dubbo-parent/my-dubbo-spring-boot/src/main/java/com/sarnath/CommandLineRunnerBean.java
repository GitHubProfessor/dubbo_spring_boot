package com.sarnath;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * 
 *
 */
@Component
public class CommandLineRunnerBean implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("CommandLineRunnerBean is invoked.......");
	}

}

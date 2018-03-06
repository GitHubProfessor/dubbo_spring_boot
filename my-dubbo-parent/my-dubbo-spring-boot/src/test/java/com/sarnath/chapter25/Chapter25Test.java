package com.sarnath.chapter25;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sarnath.chaper.chapter25.Profiles;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Chapter25Test {
	@Autowired
	private Profiles profiles;
	
	@Test
	public void test() {
	}

}

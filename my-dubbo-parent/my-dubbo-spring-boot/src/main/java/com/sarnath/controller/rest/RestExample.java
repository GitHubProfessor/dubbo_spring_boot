package com.sarnath.controller.rest;

import java.awt.List;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import com.sarnath.service.rest.ExampleService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rest")
public class RestExample {

	//@Autowired   如果通过构造方法注入的时候，那么此处可以省略掉@Autowired注解
	private ExampleService Service;
	
	public RestExample( ExampleService Service) {
		 this.Service = Service;
	}
    @RequestMapping("/home")
    Map home() {
    	Service.doService();
    	Map<String, String> map = new HashMap<String,String>();
    	map.put("hello", "Hello World REST!");
    	return map;
    }
}
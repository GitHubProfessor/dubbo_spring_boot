package com.sarnath.controller;

import org.springframework.web.bind.annotation.*;

//告知spring将结果自动转成字符串，他是@Controller和@ResponseBody的合体
@RestController
public class Example {

	@RequestMapping("/")
	String home() {
		return "Hello World!";
	}
}
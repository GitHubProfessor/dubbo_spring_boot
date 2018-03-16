package com.sarnath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//告知spring将结果自动转成字符串，他是@Controller和@ResponseBody的合体
@RestController
public class Example {
	@RequestMapping("/")
	String home() {
		return "Hello World！！！！！！！！！我来自controller";
	}
}
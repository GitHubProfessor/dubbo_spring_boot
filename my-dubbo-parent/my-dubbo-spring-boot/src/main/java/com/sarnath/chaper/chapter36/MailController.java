package com.sarnath.chaper.chapter36;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

	//注：一定要先配置spring.mail.host=smtp.163.com，否则启动时会报错找不到JavaMailSender，无法注入JavaMailSender。
	@Autowired
	private JavaMailSender javaMailSender;

	@RequestMapping("/send")
	public void sendSimpleMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("liuhaibo_ljf@163.com");
		message.setTo("liuhaibo_ljf@163.com");
		message.setSubject("主题：简单邮件");
		message.setText("测试邮件内容");
		javaMailSender.send(message);
	}
}
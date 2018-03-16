package com.sarnath.chaper.chapter35;

import javax.validation.Valid;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/validate")
//@Validated  method的参数使用Validate的时候，需要加这个注解。如果是bean的形式，就不需要了。
public class ValidateController {
	/**
	 * 通过bean的形式来使用Validate进行验证
	 * 注意
	 * @Valid 和 BindingResult 是一一对应的，如果有多个@Valid，
	 * 那么每个@Valid后面跟着的BindingResult就是这个@Valid的验证结果，顺序不能乱
	 * @param bean
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping("/bean")
    @ResponseBody
    public String bean(@Valid ValidBean bean, BindingResult bindingResult){        
        return bindingResult.hasErrors() ? 
		bindingResult.getFieldError().getDefaultMessage() : "incorrect";
    }
	
	/**
	 * 在method中对参数使用Validate方式进行验证
	 * 方法中使用Validate时，类上必须使用@Validate注解
	 * 如果使用了@Validated，那么BeanValidate也会抛出异常而不是之前的封装在BindingResult中
	 * 默认校验失败后会让方法抛出Unchecked Exception，在springboot中默认是会让其跳转到error页面，所以只要添加一个这个异常的处理器就行：
	 * 
	 * 类使用@Validated注解后，导致方法对参数验证不好用，而且连普通的传参都接收不到。调查中
	 */
	@RequestMapping("/method1")
	@ResponseBody
	public String method(@RequestParam(value = "age", defaultValue = "") String age) {
		return "111";
	}
}

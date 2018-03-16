package com.sarnath.chaper.chapter35;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
/**
 * 在bean中定于Validate的规约，在controller中通过使用bean来验证。
 * @author OM
 *
 */
public class ValidBean {
	@NotNull(message = "名字不能为空")
	private String name;

	@Min(value = 18, message = "年龄必须大于18")
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

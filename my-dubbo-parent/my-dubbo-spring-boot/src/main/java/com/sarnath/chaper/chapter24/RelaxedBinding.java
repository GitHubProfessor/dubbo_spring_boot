package com.sarnath.chaper.chapter24;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 *  24.7.2 relaxed binding
 *  properties文件在application.properties中
 *  例子说明了，spring boot对于properties文件与bean属性的匹配是很宽松的一种方式。
 *  例子告诉我们，properties文件中多种方式的fistname
 *	person.firstName
 *	person.first-name
 *	person.first_name
 *	PERSON_FIRST_NAME
 *  这几种方式，都可以注入到bean属性 firstName中来。
 * @author OM
 *
 */

@Component
@PropertySource("classpath:ConfigurationPropertires.properties")//@PropertySource注解只能用于properties文件，不能用于yml文件
@ConfigurationProperties(prefix="person")
public class RelaxedBinding {
    private String firstName;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

}

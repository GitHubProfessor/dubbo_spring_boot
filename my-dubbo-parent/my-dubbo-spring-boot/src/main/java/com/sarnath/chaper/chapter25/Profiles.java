package com.sarnath.chaper.chapter25;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component; 

/**
 * chapter25
 * application.properties文件中的spring.profiles.active=develop
 * 所以spring boot 启动时会构造加载我们用@Configuration和@Profile("develop")对应的类。
 * 如果我们的@Profile("develop")改为@Profile("product")，那么便不会加载我们这个类了。
 * 也就是说说，是否加载，取决于@Profile中的值是否存在于spring.profiles.active
 * 当不适用@Profle注解时，那么只要有@Configuration或者@Component都会被构造。从这方面讲，@Profile具有一定的限制功能。
 * @author OM
 *
 */
@Component
@Configuration
@Profile("develop")
public class Profiles {
	public Profiles() {
		System.out.println("this is develop");
	}
}

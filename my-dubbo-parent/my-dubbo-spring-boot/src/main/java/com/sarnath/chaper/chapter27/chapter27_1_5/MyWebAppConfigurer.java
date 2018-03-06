package com.sarnath.chaper.chapter27.chapter27_1_5;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * 27.1.5 Static Content(静态资源)
 * 通过此配置文件类，可实现url与静态文件的映射配置，
 * 
 * 添加此配置文件后，springboot对于静态资源的映射，除了默认的将url中/**映射到static文件夹外，
 * 还可以在url中使用如localhost:8089/myres/static.png，访问static文件夹下的static.png文件。
 * @author OM
 *
 */
@Configuration
public class MyWebAppConfigurer 
        extends WebMvcConfigurerAdapter {

	//使用时解开注释即可
  /*  @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/myres/**").addResourceLocations("classpath:/static/");
        super.addResourceHandlers(registry);
    }
*/
}

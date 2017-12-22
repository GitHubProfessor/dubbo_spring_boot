package com.sarnath;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Hello world!
 *
 * @Configuration：
 * 指出该类是 Bean 配置的信息源，相当于XML中的<beans></beans>，一般加在主类上。
 * @EnableAutoConfiguration：
 * 让 SpringBoot 根据应用所声明的依赖来对 Spring 框架进行自动配置，由于 spring-boot-starter-web 添加了Tomcat和Spring MVC，所以auto-configuration将假定你正在开发一个web应用并相应地对Spring进行设置
 * @ ComponentScan：
 * 表示将该类自动发现（扫描）并注册为Bean，可以自动收集所有的Spring组件（@Component , @Service , @Repository , @Controller 等），包括@Configuration类。
 * @SpringBootApplication：
 * @EnableAutoConfiguration、@ComponentScan和@Configuration的合集。
 *@ EnableTransactionManagement：启用注解式事务。
 */


@SpringBootApplication
/**
 * @SpringBootApplication 包括了以下几种注解：
 * @Configuration，
 * @EnableAutoConfiguration，
 * @ComponentScan：告知spring在当前包下自动去查找 components, configurations, and services
 * @EnableWebMvc：通常情况应该为springmvc程序添加此注解，但是当springboot在classpath中发现spring-webmvc时，会自动添加此注释
 *
 */
public class App
{
    public static void main( String[] args )
    {
    	SpringApplication springApplication = new SpringApplication(App.class);
    	SpringApplication.run(App.class, args);
        System.out.println( "Hello World!" );
    }
    
    
   /* @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    	//此种Lamda写法等同于下面注释的掉的原写法1.但会发现，Lamda的形式更简单
        return args -> {
            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
            
            Lamda在多线程上的应用
            * new Thread( () -> {
	            	System.out.println("In Java8, Lambda expression rocks !!");
	            	for(int i=0;i<4;i++){
	            		System.out.println(i);
	            	}
            	} 
            ).start();
        };
    }
    */
    
   /* 原写法1
    * @Bean
    * public CommandLineRunner commandLineRunner1(ApplicationContext ctx) {
		return new CommandLineRunnerImpl(ctx);
    }
    private class CommandLineRunnerImpl implements CommandLineRunner{
    	ApplicationContext ctx;
    	public CommandLineRunnerImpl(ApplicationContext ctx){
    		this.ctx = ctx;
    	}
		@Override
		public void run(String... args) throws Exception {
			System.out.println("自你故意");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                System.out.println(beanName);
            }
		}
    }*/
}

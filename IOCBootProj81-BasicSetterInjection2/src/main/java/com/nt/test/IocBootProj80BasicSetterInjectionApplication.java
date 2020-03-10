package com.nt.test;

import java.util.Calendar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//@SpringBootApplication
@Configuration
@ComponentScan(basePackages = "com.nt.test")
public class IocBootProj80BasicSetterInjectionApplication {
	
	@Bean(name="cal")
	public Calendar createCalendar() {
		return Calendar.getInstance();
	}
	

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		WishMessageGenerator generator=null;
		//get IOC container
		ctx=SpringApplication.run(IocBootProj80BasicSetterInjectionApplication.class, args);
		System.out.println(ctx.getClass());
		
		//get Target Bean class obj
		generator=ctx.getBean("wmg",WishMessageGenerator.class);
		//invoke method
		System.out.println("Wish Message ::"+generator.genrateWishMessage("raja"));
		
		//close container
		((ConfigurableApplicationContext) ctx).close();
	}

}

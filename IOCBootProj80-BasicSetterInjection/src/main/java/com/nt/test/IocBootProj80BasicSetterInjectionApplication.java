package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

//@SpringBootApplication
@Import(value = AppConfig.class)
public class IocBootProj80BasicSetterInjectionApplication {

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

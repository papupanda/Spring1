package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.beans.WishMessageGenerator;
import com.nt.config.AppConfig;

public class BasicInjectionTest {

	public static void main(String[] args) {
		ApplicationContext  ctx=null;
		WishMessageGenerator generator=null;
		//create IOC container
		ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		//get Bean
		/*	generator=ctx.getBean("wmg",WishMessageGenerator.class);
			//invoke the method
			System.out.println(generator.generateWishMessage("raja"));*/
		//close container
		((AbstractApplicationContext) ctx).close();
	}

}

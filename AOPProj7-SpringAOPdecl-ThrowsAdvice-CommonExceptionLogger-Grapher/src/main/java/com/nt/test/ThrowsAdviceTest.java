package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.service.OnlineStore;

public class ThrowsAdviceTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		OnlineStore proxy=null;
		
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Proxy object
		proxy=ctx.getBean("pfb",OnlineStore.class);
		/*//invoke method
		try {
		   System.out.println("bill Amount::"+proxy.shopping(new String[] {"shirt","pant"}, new float[] {2000,3000}));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("..........................");*/
		//invoke method
				try {
				   System.out.println("bill Amount::"+proxy.shopping(null, new float[] {2000,3000}));
				}
				catch(Exception e) {
					System.out.println(e.getClass());
					e.printStackTrace();
				}
		
		//close container
				((AbstractApplicationContext) ctx).close();

	}

}

package com.nt.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.beans.BankService;



public class AllTests {
	private static BankService service;
	private static ApplicationContext ctx;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ctx = new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		service = ctx.getBean("bankService", BankService.class);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		service = null;
		((AbstractApplicationContext) ctx).close();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCalcIntrAmount1InvalidInputs() {
		service.calcIntrAmount(0, 0, 0);
	}

	@Test
	//@Ignore
	public void testCalcIntrAmount2WithSimpleIntr() {
		float actualIntrAmt = 0.0f;
		float expectedIntrAmt = 24000.0f;
		actualIntrAmt = service.calcIntrAmount(100000, 2, 12);
		assertEquals(expectedIntrAmt, actualIntrAmt, 1.0f);
	}

	@Test
	@Ignore
	public void testCalcIntrAmount3WithCompoundIntr() {
		float actualIntrAmt = 0.0f;
		float expectedIntrAmt = 26824.15f;
		actualIntrAmt = service.calcIntrAmount(100000, 2, 12);
		assertEquals(expectedIntrAmt, actualIntrAmt, 1.0f);
	}

}

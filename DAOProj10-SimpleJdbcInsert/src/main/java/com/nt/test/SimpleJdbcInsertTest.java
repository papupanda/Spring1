package com.nt.test;

import java.sql.SQLClientInfoException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.dto.ProductDTO;
import com.nt.service.ProductMgmtService;

public class SimpleJdbcInsertTest {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		ProductMgmtService service=null;
		ProductDTO dto=null;
		//create IOC container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Bean
		service=ctx.getBean("prodService",ProductMgmtService.class);
		//prepare DTO
		dto=new ProductDTO();
		dto.setPname("Table");
		dto.setPrice(90000);
		dto.setQty(1);
		dto.setStatus(false);
		//invoke method
		try {
			System.out.println("result :::"+service.registerProduct(dto));
		}//try
		catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		//close container
		((AbstractApplicationContext) ctx).close();
	}//main
}//class

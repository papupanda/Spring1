package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class NestedBeanFactoryTestUsingAC {
	
	public static void main(String[] args) {
	   ApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create ParentContainer
		pCtx=new ClassPathXmlApplicationContext("com/nt/cfgs/business-beans.xml");
		//create child container
		cCtx=new ClassPathXmlApplicationContext(new String[] {"com/nt/cfgs/presentation-beans.xml"},pCtx);
		//get Controller class object
		controller=cCtx.getBean("controller",MainController.class);
		try {
		//invoke method
		listDTO=controller.fetchEmployeesByDesgs(new String[] {"CLERK","MANAGER","SALESMAN"});
		listDTO.forEach(dto->{
			System.out.println(dto);
		});
		}
		catch (Exception e) {
			System.out.println("Internal Problem---");
			e.printStackTrace();
		}
		System.out.println("............................................");
		try {
			//invoke method
			listDTO=controller.fetchEmployeesByDesgs(new String[] {"CLERK","MANAGER"});
			listDTO.forEach(dto->{
				System.out.println(dto);
			});
			}
			catch (Exception e) {
				System.out.println("Internal Problem---");
				e.printStackTrace();
			}
		
		//close container
		((AbstractApplicationContext) pCtx).close();
		((AbstractApplicationContext) cCtx).close();
		
	}//main
}//class

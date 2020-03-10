package com.nt.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.nt.config.BusinessConfig;
import com.nt.config.PresentationConfig;
import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class NestedBeanFactoryTestUsingAC {
	
	public static void main(String[] args) {
	   ApplicationContext pCtx=null,cCtx=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create ParentContainer
		pCtx=new  AnnotationConfigApplicationContext(BusinessConfig.class);
		//create child container
		cCtx=new AnnotationConfigApplicationContext(PresentationConfig.class);
		((AnnotationConfigApplicationContext)cCtx).setParent(pCtx);
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

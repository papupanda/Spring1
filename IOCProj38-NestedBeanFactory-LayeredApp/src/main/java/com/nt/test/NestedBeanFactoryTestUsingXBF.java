package com.nt.test;

import java.util.List;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.dto.EmployeeDTO;

public class NestedBeanFactoryTestUsingXBF {
	
	public static void main(String[] args) {
		BeanFactory pFactory=null,cFactory=null;
		MainController controller=null;
		List<EmployeeDTO> listDTO=null;
		//create ParentContainer
		pFactory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/business-beans.xml"));
		//create child container
		cFactory=new XmlBeanFactory(new ClassPathResource("com/nt/cfgs/presentation-beans.xml"),pFactory);
		//get Controller class object
		controller=cFactory.getBean("controller",MainController.class);
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
		
		
		
		
	}

}

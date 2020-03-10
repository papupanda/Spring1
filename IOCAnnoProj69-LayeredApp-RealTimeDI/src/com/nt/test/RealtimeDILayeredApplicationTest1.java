package com.nt.test;

import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.nt.controller.MainController;
import com.nt.vo.EmployeeVO;

public class RealtimeDILayeredApplicationTest1 {
	public static void main(String[] args) {
		Scanner sc=null;
		EmployeeVO vo=null;
		String eno=null,ename=null,eadd=null,bsal=null;
		MainController controller=null;
		String result=null;
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BeanPostProcessor bpp=null;
		//read inputs
		sc=new Scanner(System.in);
		System.out.println("Enter Employee number::");
		eno=sc.next();
		System.out.println("Enter employee name::");
		ename=sc.next();
		System.out.println("Enter Employee Address::");
		eadd=sc.next();
		System.out.println("Enter Employee basic Salary::");
		bsal=sc.next();
		//create EmployeeVO class object
		vo=new EmployeeVO();
		vo.setEmpNo(eno);
		vo.setEmpName(ename);
		vo.setEmpAddress(eadd);
		vo.setBasicSalary(bsal);
		//create IOC container 
		  factory=new DefaultListableBeanFactory();
		  reader=new XmlBeanDefinitionReader(factory);
		  reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		  
		bpp=factory.getBean("awbpp",BeanPostProcessor.class);
		factory.addBeanPostProcessor(bpp);
		//get Controller class obj  from IOC container
		controller=factory.getBean("controller",MainController.class);
		//invoke method
		try {
			result=controller.processEmployee(vo);
			System.out.println(result);
		}//try
		catch(Exception e) {
			e.printStackTrace();
			/*if(((SQLException)e).getErrorCode()==1)
				System.out.println("Emplyee already registered ");
			else if(((SQLException)e).getErrorCode()==12899)
				System.out.println("Emplyee info is larger than given col size ");
			else if(((SQLException)e).getErrorCode()==947)
				System.out.println("Emplyee info insufficient to insert ");
			else
				System.out.println("Unknown Internal Problem "); */
		}
	}//main
}//class

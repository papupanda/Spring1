package com.nt.test;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import com.nt.beans.BankLoanMgmt;
import com.nt.beans.IntrestAmountDetails;
import com.nt.peditor.IntrestAmountDetailsEditor;

public class CustomPETest1 {

	public static void main(String[] args) {
		
		DefaultListableBeanFactory factory=null;
		XmlBeanDefinitionReader reader=null;
		BankLoanMgmt mgmt=null;
		//create IOC container 
		factory=new DefaultListableBeanFactory();
		reader=new XmlBeanDefinitionReader(factory);
		reader.loadBeanDefinitions("com/nt/cfgs/applicationContext.xml");
		//add PropertyEditorRegistrar
		factory.addPropertyEditorRegistrar(new PropertyEditorRegistrar() {
			
			public void registerCustomEditors(PropertyEditorRegistry registry) {
				registry.registerCustomEditor(IntrestAmountDetails.class,new IntrestAmountDetailsEditor());
			}
		});
		//get Bean
		mgmt=factory.getBean("blm",BankLoanMgmt.class);
		//invoke method
		System.out.println("Result :::"+mgmt.calcSimpleIntrestAmount());

	}
	
	

}

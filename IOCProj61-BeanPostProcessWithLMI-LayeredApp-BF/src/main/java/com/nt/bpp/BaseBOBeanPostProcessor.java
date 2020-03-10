package com.nt.bpp;

import java.util.Date;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import com.nt.bo.BaseBO;

public class BaseBOBeanPostProcessor implements BeanPostProcessor {
	
	public BaseBOBeanPostProcessor() {
		System.out.println("BaseBOBeanPostProcessor.0-param constructor");
	}
	
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BaseBOBeanPostProcessor.postProcessBeforeInitialization(-,-)");
		return bean;
	}
	
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BaseBOBeanPostProcessor.postProcessAfterInitialization(-,-)");
		if(bean instanceof  BaseBO) {
			((BaseBO)bean).setDoj(new Date());
			System.out.println(bean.toString());
		}
		     return bean;
	}

}

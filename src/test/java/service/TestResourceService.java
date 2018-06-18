package service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dmetal.aop.SysResourceService;

public class TestResourceService {
	ClassPathXmlApplicationContext ac;
	@Before
	public void init() {
		ac=new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	
	@Test
	public void testSaveObject() {
		SysResourceService resourceService=(SysResourceService)ac.getBean("sysResourceServiceImpl");
		Object obj=new Object();
		resourceService.save(obj);
	}
	
	@After
	public void destroy() {
		ac.close();
	}
}
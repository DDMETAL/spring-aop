package service;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dmetal.aop.SysRoleService;

public class TestRoleService {
	ClassPathXmlApplicationContext ac;
	@Before
	public void init() {
		ac=new ClassPathXmlApplicationContext("spring-aop.xml");
	}
	
	@Test
	public void testSaveObject() {
		SysRoleService roleService=(SysRoleService)ac.getBean("sysRoleServiceImpl");
		Object obj=new Object();
		int rows =roleService.saveObject(null);
		Assert.assertEquals(1, rows);
	}
	
	@Test
	public void testUpdateObject() {
		SysRoleService roleService=(SysRoleService)ac.getBean("sysRoleServiceImpl");
		Object obj=new Object();
		roleService.updateObject(obj);
	}
	
	@After
	public void destroy() {
		ac.close();
	}
}

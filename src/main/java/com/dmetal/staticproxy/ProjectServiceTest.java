package com.dmetal.staticproxy;

public class ProjectServiceTest {
	public static void main(String[] args) {
		ProjectService projectService;
		ProjectServiceImpl projectServiceImpl=new ProjectServiceImpl();
		Object obj=new Object();
//		projectServiceImpl.saveObject(obj);
//		projectServiceImpl.updateObject(obj);
		projectService=new ProjectServiceStaticProxy(//代理类
				projectServiceImpl);//被代理类
		projectService.saveObject(obj);
		projectService.updateObject(obj);
	}
}

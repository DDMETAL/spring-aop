package com.dmetal.staticproxy;

public class ProjectServiceTest {
	public static void main(String[] args) {
		ProjectService projectService;
		ProjectServiceImpl projectServiceImpl=new ProjectServiceImpl();
		Object obj=new Object();
//		projectServiceImpl.saveObject(obj);
//		projectServiceImpl.updateObject(obj);
		projectService=new ProjectServiceStaticProxy(//������
				projectServiceImpl);//��������
		projectService.saveObject(obj);
		projectService.updateObject(obj);
	}
}

package com.dmetal.dynamicproxy;

import com.dmetal.staticproxy.ProjectService;
import com.dmetal.staticproxy.ProjectServiceImpl;

public class TestTeamService {
	public static void main(String[] args) {
		//目标对象
		TeamService teamService=new TeamServiceImpl();
		Object obj=new Object();
//		teamService.save(obj);
//		teamService.update(obj);
		//创建代理对象(为TeamServiceImpl创建代理InvocationHandler)
		ProxyHandler pHandler=new ProxyHandler();
		TeamService proxyObject=(TeamService)pHandler.newProxy(teamService);
		//1.调用代理对象的方法
		//2.底层调用pHandler的invoke方法
		//3.invoke方法执行调用目标对象对应的方法
		proxyObject.save(obj);
		proxyObject.update(obj);
		
		//创建代理对象(ProjectServiceImpl创建代理)
		ProjectService projectService=new ProjectServiceImpl();
		ProjectService projectServiceProxy=(ProjectService)pHandler.newProxy(projectService);
		projectServiceProxy.saveObject(obj);
		projectServiceProxy.updateObject(obj);
	}
}

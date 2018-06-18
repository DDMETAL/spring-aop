package com.dmetal.dynamicproxy;

import com.dmetal.staticproxy.ProjectService;
import com.dmetal.staticproxy.ProjectServiceImpl;

public class TestTeamService {
	public static void main(String[] args) {
		//Ŀ�����
		TeamService teamService=new TeamServiceImpl();
		Object obj=new Object();
//		teamService.save(obj);
//		teamService.update(obj);
		//�����������(ΪTeamServiceImpl��������InvocationHandler)
		ProxyHandler pHandler=new ProxyHandler();
		TeamService proxyObject=(TeamService)pHandler.newProxy(teamService);
		//1.���ô������ķ���
		//2.�ײ����pHandler��invoke����
		//3.invoke����ִ�е���Ŀ������Ӧ�ķ���
		proxyObject.save(obj);
		proxyObject.update(obj);
		
		//�����������(ProjectServiceImpl��������)
		ProjectService projectService=new ProjectServiceImpl();
		ProjectService projectServiceProxy=(ProjectService)pHandler.newProxy(projectService);
		projectServiceProxy.saveObject(obj);
		projectServiceProxy.updateObject(obj);
	}
}

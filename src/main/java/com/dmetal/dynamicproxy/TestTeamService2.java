package com.dmetal.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestTeamService2 {
	public static void main(String[] args) {
		Object obj=new Object();
		//目标对象
		final TeamService teamService=new TeamServiceImpl();
		//为目标对象创建代理对象
		TeamService teamServiceProxy=
		(TeamService)Proxy.newProxyInstance(
				teamService.getClass().getClassLoader(), 
				teamService.getClass().getInterfaces(), 
				new InvocationHandler() {
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						long t1=System.currentTimeMillis();
						Object result=method.invoke(teamService,args);
						long t2=System.currentTimeMillis();
						System.out.println(method.getName()+"方法执行时间:"+(t2-t1));
						return result;
					}
				});
		Object result=teamServiceProxy.save(obj);
		System.out.println(result);
		teamServiceProxy.update(obj);
		
	}
}

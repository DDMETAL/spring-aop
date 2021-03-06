package com.dmetal.staticproxy;
/**
 * 扩展类(可以为实现了ProjectService接口的所有类添加扩展功能)
 * 此类通常被称之为代理类
 * 这个代理类的特点：
 * 	①与被代理类实现相同的接口
 * 	②代理被代理对象实现功能的扩展
 * 静态代理：自己写的类，它与被代理对象实现了共同接口
 *  ①优点：可以很方便的为代理对象实现功能扩展
 *  ②缺点：若有很多接口的实现类都需这样的功能扩展，则需创建很多这样的代理类，比较麻烦
 */
public class ProjectServiceStaticProxy implements ProjectService{
	private ProjectService projectService;
	public ProjectServiceStaticProxy(ProjectService projectService) {
		this.projectService=projectService;
	}
	public void saveObject(Object obj) {
		long t1=System.currentTimeMillis();
		projectService.saveObject(obj);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("saveObject方法执行时间="+t);
	}

	public void updateObject(Object obj) {
		long t1=System.currentTimeMillis();
		projectService.updateObject(obj);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("updateObject方法执行时间="+t);
	}

}

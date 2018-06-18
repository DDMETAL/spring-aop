package com.dmetal.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**代理对象的处理对象*/
public class ProxyHandler implements InvocationHandler{
	/**代表目标对象(要为此对象产生代理对象)*/
	private Object target;
	/**
	 * 
	 * @param target 目标对象(之后要为此对象产生代理对象)
	 * @return 返回目标对象的代理对象
	 */
	public Object newProxy(Object target) {
		this.target=target;
		//为目标对象创建代理对象(此过程是动态的)
		//底层创建的这个代理对象也会与被代理对象实现相同接口
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loader目标类的加载器
				target.getClass().getInterfaces(),//interfaces目标类实现的接口
				this);//InvocationHandler
	}
	/**在执行目标对象方法时，会默认调用此方法
	 * @param proxy 代理对象
	 * @param method 代表方法对象(通过此对象执行目标方法)
	 * @param args 用于接收目标方法中实际参数的值
	 */
	public Object invoke(
			Object proxy, 
			Method method, 
			Object[] args) throws Throwable {
		long t1=System.currentTimeMillis();
		//执行目标对象target的method
		//例如执行TeamServiceImpl对象的save方法
		Object result=method.invoke(target, args);
		long t2=System.currentTimeMillis();
		System.out.println(method.getName()+"方法执行时间:"+(t2-t1));
		return result;
	}
	
}

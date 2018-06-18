package com.dmetal.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**�������Ĵ������*/
public class ProxyHandler implements InvocationHandler{
	/**����Ŀ�����(ҪΪ�˶�������������)*/
	private Object target;
	/**
	 * 
	 * @param target Ŀ�����(֮��ҪΪ�˶�������������)
	 * @return ����Ŀ�����Ĵ������
	 */
	public Object newProxy(Object target) {
		this.target=target;
		//ΪĿ����󴴽��������(�˹����Ƕ�̬��)
		//�ײ㴴��������������Ҳ���뱻�������ʵ����ͬ�ӿ�
		return Proxy.newProxyInstance(
				target.getClass().getClassLoader(),//loaderĿ����ļ�����
				target.getClass().getInterfaces(),//interfacesĿ����ʵ�ֵĽӿ�
				this);//InvocationHandler
	}
	/**��ִ��Ŀ����󷽷�ʱ����Ĭ�ϵ��ô˷���
	 * @param proxy �������
	 * @param method ����������(ͨ���˶���ִ��Ŀ�귽��)
	 * @param args ���ڽ���Ŀ�귽����ʵ�ʲ�����ֵ
	 */
	public Object invoke(
			Object proxy, 
			Method method, 
			Object[] args) throws Throwable {
		long t1=System.currentTimeMillis();
		//ִ��Ŀ�����target��method
		//����ִ��TeamServiceImpl�����save����
		Object result=method.invoke(target, args);
		long t2=System.currentTimeMillis();
		System.out.println(method.getName()+"����ִ��ʱ��:"+(t2-t1));
		return result;
	}
	
}

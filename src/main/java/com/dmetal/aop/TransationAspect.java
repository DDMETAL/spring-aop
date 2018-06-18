package com.dmetal.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**��������*/

@Order(2)
@Aspect
@Component
public class TransationAspect {
	//���������(���Ʒ�����һ�����ϣ�����������������ʽ�����з�����ִ�����֪ͨ)
	//���е�֪ͨ���������Ҫ��չ��ҵ��
	@Pointcut("execution(* com.dmetal.aop.*ServiceImpl.*(..))")
	public void aspectMethod() {}
	
	@Before("aspectMethod()")
	public void beforeMethod(JoinPoint point) {//JoinPoint�����ӵ�,��ʾ�����ĳһ������
		String methodName=point.getSignature().getName();
		//point.getArgs();��ȡ����
		System.out.println("Ϊ"+methodName+"�����ӣ���������");
	}
	
	@AfterReturning("aspectMethod())")
	public void returnMethod() {
		System.out.println("�ύ����");
		System.out.println("�ر�����");
	}
	@AfterThrowing("aspectMethod()")
	public void throwMethod() {
		System.out.println("�ع�����");
		System.out.println("�ر�����");
	}
	
//	@After("execution(public int com.dmetal.aop.SysRoleServiceImpl.saveObject(..))")
//	public void after() {
//		System.out.println("�ر�����");
//	}
}

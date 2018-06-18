package com.dmetal.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect//将此对象声明为一个切面
@Component//声明这是一个组件(可以由spring管理)
public class TimingAspect {
	/**使用@before声明这是一个前置通知，在目标方法执行之前执行的一段代码
	 * bean(sysRoleServiceImpl)称为一个切入点*/
	@Before("bean(*ServiceImpl)")
	public void timeBefore() {
		long start=System.currentTimeMillis();
		System.out.println("start="+start);
	}
	/**返回通知,出现异常不执行*/
	@AfterReturning("bean(*ServiceImpl)")
	public void returnMethod() {
		System.out.println("returnMethod(方法正常返回)");
	}
	/**异常通知，出现异常执行*/
	@AfterThrowing("bean(*ServiceImpl)")
	public void throwMethod() {
		System.out.println("throwMethod(出现异常)");
	}
	/**后置通知*/
	@After("bean(*ServiceImpl)")
	public void timeAfter() {
		long end=System.currentTimeMillis();
		System.out.println("end="+end);
	}
	//@Around(环绕通知，相当于before和after)
}

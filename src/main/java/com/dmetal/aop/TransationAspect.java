package com.dmetal.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**事务切面*/

@Order(2)
@Aspect
@Component
public class TransationAspect {
	//定义切入点(类似方法的一个集合，在满足这个切入点表达式的所有方法上执行相关通知)
	//所有的通知可以理解是要扩展的业务
	@Pointcut("execution(* com.dmetal.aop.*ServiceImpl.*(..))")
	public void aspectMethod() {}
	
	@Before("aspectMethod()")
	public void beforeMethod(JoinPoint point) {//JoinPoint是连接点,表示具体的某一个方法
		String methodName=point.getSignature().getName();
		//point.getArgs();获取参数
		System.out.println("为"+methodName+"打开链接，开启事务");
	}
	
	@AfterReturning("aspectMethod())")
	public void returnMethod() {
		System.out.println("提交事务");
		System.out.println("关闭链接");
	}
	@AfterThrowing("aspectMethod()")
	public void throwMethod() {
		System.out.println("回滚事务");
		System.out.println("关闭链接");
	}
	
//	@After("execution(public int com.dmetal.aop.SysRoleServiceImpl.saveObject(..))")
//	public void after() {
//		System.out.println("关闭链接");
//	}
}

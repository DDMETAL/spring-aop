package com.dmetal.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Aspect//���˶�������Ϊһ������
@Component//��������һ�����(������spring����)
public class TimingAspect {
	/**ʹ��@before��������һ��ǰ��֪ͨ����Ŀ�귽��ִ��֮ǰִ�е�һ�δ���
	 * bean(sysRoleServiceImpl)��Ϊһ�������*/
	@Before("bean(*ServiceImpl)")
	public void timeBefore() {
		long start=System.currentTimeMillis();
		System.out.println("start="+start);
	}
	/**����֪ͨ,�����쳣��ִ��*/
	@AfterReturning("bean(*ServiceImpl)")
	public void returnMethod() {
		System.out.println("returnMethod(������������)");
	}
	/**�쳣֪ͨ�������쳣ִ��*/
	@AfterThrowing("bean(*ServiceImpl)")
	public void throwMethod() {
		System.out.println("throwMethod(�����쳣)");
	}
	/**����֪ͨ*/
	@After("bean(*ServiceImpl)")
	public void timeAfter() {
		long end=System.currentTimeMillis();
		System.out.println("end="+end);
	}
	//@Around(����֪ͨ���൱��before��after)
}

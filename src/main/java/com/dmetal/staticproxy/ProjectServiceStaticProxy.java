package com.dmetal.staticproxy;
/**
 * ��չ��(����Ϊʵ����ProjectService�ӿڵ������������չ����)
 * ����ͨ������֮Ϊ������
 * �����������ص㣺
 * 	���뱻������ʵ����ͬ�Ľӿ�
 * 	�ڴ����������ʵ�ֹ��ܵ���չ
 * ��̬�����Լ�д���࣬���뱻�������ʵ���˹�ͬ�ӿ�
 *  ���ŵ㣺���Ժܷ����Ϊ�������ʵ�ֹ�����չ
 *  ��ȱ�㣺���кܶ�ӿڵ�ʵ���඼�������Ĺ�����չ�����贴���ܶ������Ĵ����࣬�Ƚ��鷳
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
		System.out.println("saveObject����ִ��ʱ��="+t);
	}

	public void updateObject(Object obj) {
		long t1=System.currentTimeMillis();
		projectService.updateObject(obj);
		long t2=System.currentTimeMillis();
		long t=t2-t1;
		System.out.println("updateObject����ִ��ʱ��="+t);
	}

}

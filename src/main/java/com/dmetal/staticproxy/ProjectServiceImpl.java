package com.dmetal.staticproxy;

public class ProjectServiceImpl implements ProjectService{

	public void saveObject(Object obj) {
		System.out.println("save");
		//dao.insertObject
		//ģ�ⷽ������ִ��
		try {Thread.sleep(1000);} catch (Exception e) {}	
	}

	public void updateObject(Object obj) {
		System.out.println("update");
		//ģ�ⷽ������ִ��(dao.updateObject)
		try {Thread.sleep(1000);} catch (Exception e) {}
		
	}

}

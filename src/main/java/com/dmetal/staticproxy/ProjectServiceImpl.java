package com.dmetal.staticproxy;

public class ProjectServiceImpl implements ProjectService{

	public void saveObject(Object obj) {
		System.out.println("save");
		//dao.insertObject
		//模拟方法正在执行
		try {Thread.sleep(1000);} catch (Exception e) {}	
	}

	public void updateObject(Object obj) {
		System.out.println("update");
		//模拟方法正在执行(dao.updateObject)
		try {Thread.sleep(1000);} catch (Exception e) {}
		
	}

}

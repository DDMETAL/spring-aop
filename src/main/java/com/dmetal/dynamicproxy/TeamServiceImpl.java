package com.dmetal.dynamicproxy;

public class TeamServiceImpl implements TeamService{

	public int save(Object obj) {
		System.out.println("save");
		return 1;
	}

	public int update(Object obj) {
		System.out.println("update");
		return 1;
	}

}

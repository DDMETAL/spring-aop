package com.dmetal.aop;

import org.springframework.stereotype.Service;

@Service
public class SysResourceServiceImpl implements SysResourceService{

	public void save(Object obj) {
		System.out.println("save");
		
	}

	public void update(Object obj) {
		System.out.println("update");
		
	}
	

}

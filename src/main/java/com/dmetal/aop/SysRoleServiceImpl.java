package com.dmetal.aop;

import org.springframework.stereotype.Service;

/**
 * 
 * try{
 * 		before
 * 		...
 * 		return
 * 		afterReturn
 * 	}catch{
 * 
 * 	}finally{
 * 		after()	
 * }
 * @author NiCo
 *
 */
@Service
public class SysRoleServiceImpl implements SysRoleService{

	public int saveObject(Object obj) {
		//before
		System.out.println("saveObject");
		if(obj==null)throw new NullPointerException();
		return 1;
		//afterReturn
	}

	public void updateObject(Object obj) {
		System.out.println("updateObject");
	}

}

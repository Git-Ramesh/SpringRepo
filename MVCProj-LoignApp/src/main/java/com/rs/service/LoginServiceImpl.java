package com.rs.service;

import org.springframework.beans.BeanUtils;

import com.rs.bo.LoginBO;
import com.rs.dao.LoginDAO;
import com.rs.dto.LoginDTO;

public class LoginServiceImpl implements LoginService{
	private LoginDAO dao;
	
	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}

	@Override
	public String checkAuthentication(LoginDTO loginDTO) {
		LoginBO loginBO=null;
		String status="Login failed, invalid username or password";
		int count=0;
		
		loginBO=new LoginBO();
		BeanUtils.copyProperties(loginDTO,loginBO);
		count=dao.checkLogin(loginBO);
		System.out.println(count);
		if(count>0)
			status="Login successful";
		return status;
	}
}
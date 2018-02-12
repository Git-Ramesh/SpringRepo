package com.rs.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.rs.bo.LoginBO;

public class LoginDAOImpl implements LoginDAO {
	private static final String CHECK_LOGIN="SELECT COUNT(*) FROM USERS WHERE USERNAME=? AND PASSWORD=?";
	
	private JdbcTemplate jt;
	
	public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}

	@Override
	public int checkLogin(LoginBO loginBO) {
		int count = 0;
		count = jt.queryForObject(CHECK_LOGIN,Integer.class,loginBO.getUsername(),loginBO.getPassword());
		
		return count;
	}
}
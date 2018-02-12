package com.rs.service;

import com.rs.dto.LoginDTO;

public interface LoginService {
	public String checkAuthentication(LoginDTO loginDTO);
}

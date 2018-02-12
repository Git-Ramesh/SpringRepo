package com.rs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.BeanUtils;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.rs.command.LoginCommand;
import com.rs.dto.LoginDTO;
import com.rs.service.LoginService;

@SuppressWarnings("deprecation")
public class LoginController extends SimpleFormController{
	private LoginService loginService;
	
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	@Override
	public ModelAndView onSubmit(HttpServletRequest req, HttpServletResponse res, Object command,
			BindException errors) throws Exception {
		ModelAndView mav=null;
		LoginDTO loginDTO=null;
		String status=null;
		
		
		LoginCommand loginCommand=(LoginCommand)command;
		loginDTO=new LoginDTO();
		BeanUtils.copyProperties(loginCommand, loginDTO);
		status=loginService.checkAuthentication(loginDTO);
		mav=new ModelAndView();
		mav.addObject("status", status);
		mav.setViewName("login_result");
		return mav;
	}
}

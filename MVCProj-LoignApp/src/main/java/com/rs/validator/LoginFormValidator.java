package com.rs.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.rs.command.LoginCommand;

public class LoginFormValidator implements Validator {
	public LoginFormValidator() {
		System.out.println("LoginFormValidator: 0-param constr");
	}

	@Override
	public boolean supports(Class<?> cls) {
		return cls.isAssignableFrom(LoginCommand.class);
	}

	@Override
	public void validate(Object command, Errors errors) {
		System.out.println("LoginFormValidator: validate(-,-)");
		LoginCommand cmd=(LoginCommand) command;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username","username.errorMsg","Please fill username");
		ValidationUtils.rejectIfEmpty(errors, "password", "password.errorMsg", "Plase fill password filed");
		if(cmd.getPassword().trim().length()<6)
			errors.reject("password","password.strengthMsg");
	}

}

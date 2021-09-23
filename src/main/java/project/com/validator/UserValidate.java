package project.com.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import project.com.dao.UserDao;
import project.com.model.Users;
import project.com.service.UserService;

@Component
public class UserValidate implements Validator{
	
	@Autowired
	private UserService userService;

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return clazz == Users.class;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Users users = (Users)target;
		ValidationUtils.rejectIfEmpty(errors, "email", "Min.Users.Email");
		ValidationUtils.rejectIfEmpty(errors, "password", "Min.Users.Password");
		if(!StringUtils.isEmpty(users.getEmail()) && !StringUtils.isEmpty(users.getPassword())) {
			Users user = userService.findUser(users.getEmail());
			if(users.getEmail().equals(user.getEmail()) && user != null) {
				if(!users.getPassword().equals(user.getPassword())) {
					errors.rejectValue("password", "Min.Users.Password");
				}
			}else {
				errors.rejectValue("email", "Min.Users.Email");
			}
		}
	}

}

package main.user.registration;

import main.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Service
public class CommandValidator implements Validator{

    private UserDao userDao;

    @Autowired
    public CommandValidator(UserDao securityUserDao) {
        this.userDao = securityUserDao;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserRegistrationCommand.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserRegistrationCommand command = (UserRegistrationCommand) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
        if(userDao.existsByEmail(command.getEmail())){
            errors.rejectValue("email", "email.exists");
        }
    }
}

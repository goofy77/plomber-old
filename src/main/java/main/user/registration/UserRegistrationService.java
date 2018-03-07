package main.user.registration;

import main.security.user.SecurityUser;
import main.security.user.SecurityUserDao;
import main.models.User;
import main.user.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRegistrationService {

    private final UserDao userDao;
    private final SecurityUserDao securityUserDao;

    @Autowired
    public UserRegistrationService(UserDao userDao, SecurityUserDao securityUserDao) {
        this.userDao = userDao;
        this.securityUserDao = securityUserDao;
    }

    User registerUser(UserRegistrationCommand command) {
        SecurityUser securityUser = createSecurityUser(command);
        User user = createUser(command, securityUser);
        return userDao.save(user);
    }

    private User createUser(UserRegistrationCommand command, SecurityUser securityUser) {
        return new User(
                command.getEmail(),
                securityUser,
                command.getFirstName(),
                command.getLastName(),
                command.getCompanyName()
        );
    }

    private SecurityUser createSecurityUser(UserRegistrationCommand command){
        SecurityUser securityUser = new SecurityUser(command.getEmail(), command.getPassword());
        return securityUserDao.save(securityUser);
    }

    boolean emailExists(String email) {
        return userDao.existsByEmail(email);
    }
}

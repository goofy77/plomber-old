package main.user.registration;

import main.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRegistrationController {

    private final UserRegistrationService userService;
    private final CommandValidator commandValidator;

    @Autowired
    public UserRegistrationController(UserRegistrationService userService, CommandValidator commandValidator) {
        this.userService = userService;
        this.commandValidator = commandValidator;
    }

    @PostMapping("/register")
    public User registerNewUser(@Validated @RequestBody UserRegistrationCommand userRegistrationCommand) {
        return userService.registerUser(userRegistrationCommand);
    }

    @GetMapping(value = "/register", params = "email")
    public boolean checkIfEmailExists(String email){
        return userService.emailExists(email);
    }

    @InitBinder("userRegistrationCommand")
    public void updateValidator(WebDataBinder binder) {
        binder.setValidator(commandValidator);
    }
}

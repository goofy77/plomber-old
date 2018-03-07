package main.user.registration;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

class UserRegistrationCommand {

    @NotBlank
    private String password;
    @Email
    @NotBlank
    private String email;
    private String firstName;
    private String lastName;
    private String companyName;

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCompanyName() {
        return companyName;
    }
}

package main.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import main.security.user.SecurityUser;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class User {

    @Id
    private String userId;

    private String email;

    @JsonIgnore
    private SecurityUser securityUser;

    private String firstName;

    private String lastName;

    private String companyName;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

    public User() {
    }

    public User(String email, SecurityUser securityUser, String firstName, String lastName, String companyName) {
        this.email = email;
        this.securityUser = securityUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.createdAt = LocalDateTime.now();
    }

    public String getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public SecurityUser getSecurityUser() {
        return securityUser;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}

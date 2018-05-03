package com.eduboooks.test.controllers.vm;



import com.eduboooks.test.config.Constants;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


/**
 * View Model object for storing a user's credentials.
 */
public class LoginVM {

    @Pattern(regexp = Constants.LOGIN_REGEX)
    @NotNull
    @Size(min = 1, max = 50)
    private String email;

    @NotNull
    @Size(min = 4, max = 100)
    private String password;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginVM{" +
            "username='" + email + '\'' +
            '}';
    }
}

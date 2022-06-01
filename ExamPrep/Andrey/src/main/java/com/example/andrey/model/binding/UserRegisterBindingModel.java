package com.example.andrey.model.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class UserRegisterBindingModel {
    @NotBlank(message = "Username cannot be empty.")
    @Size(min = 2, message = "Username must be more than two character.")
    private String username;
    @Email(message = "Email must be valid.")
    private String email;
    @Positive(message ="Budget must be more or equal to 0.")
    private BigDecimal budget;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 2, message = "Password must be more than two character.")
    private String password;
    @NotBlank(message = "Password cannot be empty")
    @Size(min = 2, message = "Password must be more than two character")
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public UserRegisterBindingModel setBudget(BigDecimal budget) {
        this.budget = budget;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}

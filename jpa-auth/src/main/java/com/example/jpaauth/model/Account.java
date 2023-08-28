package com.example.jpaauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "account")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @Size(min = 8)
    String username;

    @Pattern.List({
            @Pattern(regexp = "^(?=.*[a-z]).{8,}$", message = "Password must contain at least one lowercase letter"),
            @Pattern(regexp = "^(?=.*[A-Z]).{8,}$", message = "Password must contain at least one uppercase letter"),
            @Pattern(regexp = "^(?=.*\\d).{8,}$", message = "Password must contain at least one digit"),
            @Pattern(regexp = "^(?=.*[@#$%^&+=]).{8,}$", message = "Password must contain at least one special character"),
    })
    @Size(min = 8, message = "Password must be at least 8 characters long")
    String password;

    @Pattern(
            regexp = "^(?=.*[a-zA-Z0-9])([a-zA-Z0-9._%+-]+@(gmail\\.com|icloud\\.com|yahoo\\.com))$",
            message = "Please provide a valid email address with domains: gmail.com, icloud.com, or yahoo.com"
    )
    @NotNull
    String email;

    String firstName;

    String lastName;

    String role;

}

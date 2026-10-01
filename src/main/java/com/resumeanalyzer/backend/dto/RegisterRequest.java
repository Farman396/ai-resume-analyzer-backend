package com.resumeanalyzer.backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    @Pattern(
            regexp = "^[a-zA-Z ]+$",
            message = "Name can contain only letters and spaces"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address")
    @Size(max = 50, message = "Email cannot exceed 50 characters")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 25, message = "Password must be between 8 and 25 characters")
    private String password;
}

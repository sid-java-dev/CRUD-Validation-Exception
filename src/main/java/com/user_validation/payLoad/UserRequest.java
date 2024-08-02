package com.user_validation.payLoad;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class UserRequest {
    @NotNull(message = "name should not be null")
    @NotEmpty(message = "name should not be empty")
    private String name;

    @Email(message = "invalid email address")
    private String email;

    @Pattern(regexp = "^[6-9]\\d{9}$", message = "invalid mobile number entered")
    private String mobile;

    @Min(value = 18, message = "age should not be less than 18")
    @Max(value = 60, message = "age should not be more than 60")
    private int age;

    @NotBlank(message = "nationality should not be blank")
    private String nationality;
}

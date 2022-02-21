package com.example.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {

    private long id;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z][A-zA-Z]*", message = "First name must not contain numbers")
    private String firstName;

    @NotEmpty
    @Pattern(regexp = "[a-zA-Z][A-zA-Z]*", message = "Last name must not contain numbers")
    private String lastName;

    @NotEmpty
    @Email (message = "Email is invalid")
    private String emailId;

}

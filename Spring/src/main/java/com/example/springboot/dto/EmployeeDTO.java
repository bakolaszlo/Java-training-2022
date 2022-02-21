package com.example.springboot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class EmployeeDTO {

    private long id;

    private String firstName;

    private String lastName;

    private String emailId;

}

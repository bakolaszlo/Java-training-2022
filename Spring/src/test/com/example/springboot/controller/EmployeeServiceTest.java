package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.model.Employee;
import com.example.springboot.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.util.Assert;

public class EmployeeServiceTest {

    @MockBean
    EmployeeService service;

    @Test
    public void createEmployeeTest() throws Exception {
        EmployeeDTO employee = new EmployeeDTO();
        Mockito.when(service.createEmployee(Mockito.any())).thenReturn(employee);
        employee.setFirstName("Marin");
        employee.setLastName("Popescu");
        employee.setEmailId("asd@gmail.com");
        EmployeeDTO result = service.createEmployee(employee);
        Assert.notNull(result);

    }
}

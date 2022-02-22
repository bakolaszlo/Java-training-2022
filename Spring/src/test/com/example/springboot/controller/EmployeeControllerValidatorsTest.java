package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerValidatorsTest {
    private final String API_URL = "/api/v1/employees";
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeService service;

    @Test
    public void AddEmployee() throws Exception{
        EmployeeDTO employee = service.getEmployeeById(1L);
        employee.setId(6);
        employee.setFirstName("Test13");
        mvc.perform(post(API_URL).contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(employee))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    public static String asJsonString(EmployeeDTO employeeDTO) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(employeeDTO);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

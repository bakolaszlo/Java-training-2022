package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import javax.print.attribute.standard.Media;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.CoreMatchers.is;


@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest {
    private final String API_URL = "/api/v1/employees";
    @Autowired
    private MockMvc mvc;

    @Autowired
    private EmployeeService service;

    @Test
    public void getAllEmployees() throws Exception {
        mvc.perform(get(API_URL)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName", is("John")))
                .andExpect(jsonPath("$[1].firstName", is("Mike")))
                .andExpect(jsonPath("$",hasSize(5)));
    }

    @Test
    public void getSingleEmployee() throws Exception {
        String id = "/1";
        mvc.perform(get(API_URL+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.firstName",is("John")))
                .andExpect(jsonPath("$.*",hasSize(4)));
    }

    @Test
    public void AddEmployee() throws Exception{
        EmployeeDTO employee = service.getEmployeeById(1L);
        employee.setId(6);
        employee.setFirstName("Test");
        mvc.perform(post(API_URL).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employee))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists());
    }

    @Test
    public void UpdateEmployee() throws Exception {
        String id = "/1";
        EmployeeDTO employeeToUpdate = service.getEmployeeById(1);
        employeeToUpdate.setLastName("Updated");
        mvc.perform(put(API_URL+id).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(employeeToUpdate))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.lastName", is("Updated")));
    }

    @Test
    public void DeleteEmployee() throws Exception {
        String id = "/1";
        mvc.perform(delete(API_URL+id)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.deleted",is(true)));
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

package com.example.springboot.misc;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.model.Employee;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    Employee employeeDtoToEmployee(EmployeeDTO employeeDTO);
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    List<EmployeeDTO> employeeToEmployeeDTO(List<Employee> employees);
}

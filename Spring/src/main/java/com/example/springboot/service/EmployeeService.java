package com.example.springboot.service;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.exception.ResourcesNotFoundException;
import com.example.springboot.misc.EmployeeMapper;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;
    private final EmployeeMapper mapper;

    public List<EmployeeDTO> getAllEmployees() {
        log.info("Return all employees");
        return mapper.employeeToEmployeeDTO(repo.findAll());
    }

    public EmployeeDTO getEmployeeById(long id) {
        log.info("Get employee by Id"+id);
        return mapper.employeeToEmployeeDTO(repo.findById(id).orElse(null));
    }

    public EmployeeDTO createEmployee(EmployeeDTO employee){
        log.info("Create employee"+employee);
        return mapper.employeeToEmployeeDTO(repo.save(mapper.employeeDtoToEmployee(employee)));
    }

    public EmployeeDTO updateEmployee(long id,EmployeeDTO employeeDetails) {
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee with id: "+ id + " does not exists!"));
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmailId(employeeDetails.getEmailId());
        Employee updatedEmployee = repo.save(mapper.employeeDtoToEmployee(employeeDetails));

        return mapper.employeeToEmployeeDTO(updatedEmployee);
    }

    public Map<String, Boolean> deleteEmployee(long id){
        Employee employee = repo.findById(id)
                .orElseThrow(() -> new ResourcesNotFoundException("Employee with id: "+ id + " does not exists!"));
        repo.delete(employee);
        return Map.of("deleted", Boolean.TRUE);
    }
}

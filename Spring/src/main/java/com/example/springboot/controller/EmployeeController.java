package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.exception.ResourcesNotFoundException;
import com.example.springboot.misc.EmployeeMapper;
import com.example.springboot.model.Employee;
import com.example.springboot.repository.EmployeeRepository;
import com.example.springboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees() {
		return service.getAllEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
			return ResponseEntity.ok(service.getEmployeeById(id));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
		return ResponseEntity.ok(service.deleteEmployee(id));
	}

	// create employee
	@PostMapping("/employees")
	public EmployeeDTO createEmployee(@RequestBody EmployeeDTO employee){
		return service.createEmployee(employee);
	}

	//update
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDetails) {
		return ResponseEntity.ok(service.updateEmployee(id, employeeDetails));
	}


}

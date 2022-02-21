package com.example.springboot.controller;

import com.example.springboot.dto.EmployeeDTO;
import com.example.springboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@Slf4j
@Validated
@RestController
@RequestMapping("api/v1")
@RequiredArgsConstructor
public class EmployeeController {

	private final EmployeeService service;

	@GetMapping("/employees")
	public List<EmployeeDTO> getAllEmployees() {
		log.info("Get all employees");
		return service.getAllEmployees();
	}

	@GetMapping(path = "/employees/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
		log.info("Get employee with id: "+id);
			return ResponseEntity.ok(service.getEmployeeById(id));
	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable long id){
		log.info("Employee with id: "+id+" was deleted.");
		return ResponseEntity.ok(service.deleteEmployee(id));
	}

	// create employee
	@PostMapping("/employees")
	public EmployeeDTO createEmployee(@RequestBody @Valid EmployeeDTO employee){
		log.info("Creating employee: "+ employee.toString());
		return service.createEmployee(employee);
	}

	//update
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable long id, @RequestBody @Valid EmployeeDTO employeeDetails) {
		log.info("Updating employee: "+ employeeDetails.toString());
		return ResponseEntity.ok(service.updateEmployee(id, employeeDetails));
	}


}

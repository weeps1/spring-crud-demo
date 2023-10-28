package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.dao.EmployeeRepository;
import com.luv2code.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    // quick and dirty sol : inject employee dao (we'll refactor later)
    private EmployeeRepository employeeRepository;


    @Autowired
    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }



    @GetMapping("/employees/weeps")
    public Employee getEmp() {
        return employeeRepository.getWeeps();
    }

    //expose "/employee" and return a list of employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId) {
        var employee = employeeRepository.findById(employeeId);

        Employee theEmp = null;

        if (employee.isPresent()) {
            theEmp = employee.get();
        } else
            throw new RuntimeException("Employee not found " + employeeId);

        return theEmp;
    }

    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee) {
        employee.setId(0);

        return employeeRepository.save(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        var existingEmp = employeeRepository.save(employee);

        return existingEmp;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId) {
        var tempEmp = employeeRepository.findById(employeeId);

        if (tempEmp == null)
            throw new RuntimeException("Employee not found");

        employeeRepository.deleteById(employeeId);

        return "Deleted employee id : " + employeeId;
    }

}

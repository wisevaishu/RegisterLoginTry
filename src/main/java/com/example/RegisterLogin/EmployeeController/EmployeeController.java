package com.example.RegisterLogin.EmployeeController;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("api/v1/employee")
@CrossOrigin(origins = "http://localhost:8082")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee (@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);

        return id;
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginEmployee (@RequestBody LoginDto loginDto) {
        LoginResponse loginResponse = employeeService.loginEmployee(loginDto);
        return ResponseEntity.ok(loginResponse);
    }
}

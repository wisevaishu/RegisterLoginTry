package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

    LoginResponse loginEmployee(LoginDto loginDto);
}

package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import org.springframework.stereotype.Service;


public interface EmployeeService {

    String addEmployee(EmployeeDTO employeeDTO);

}

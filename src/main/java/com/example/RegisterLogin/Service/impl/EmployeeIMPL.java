package com.example.RegisterLogin.Service.impl;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import com.example.RegisterLogin.Dto.LoginDto;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repo.EmployeeRepo;
import com.example.RegisterLogin.Service.EmployeeService;
import com.example.RegisterLogin.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeIMPL implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public String addEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee(
                employeeDTO.getEmployeeid(),
                employeeDTO.getEmployeename(),
                employeeDTO.getEmail(),
                this.passwordEncoder.encode(employeeDTO.getPassword())
        );

        employeeRepo.save(employee);

        return (employee.getEmployeename() == null )? "error" : employee.getEmployeename();
    }

    @Override
    public LoginResponse loginEmployee(LoginDto loginDto) {
        String msg = "";
        Employee employee1 = employeeRepo.findByEmail(loginDto.getEmail());
        if (employee1 != null) {
            String password = loginDto.getPassword();
            String encodedPassword = employee1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight){
                Optional<Employee> employee = employeeRepo.findOneByEmailAndPassword(loginDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new LoginResponse("Login Success", true);
                }
                else {
                    return new LoginResponse("Login Failed", false);
                }
            }
            else {
                return new LoginResponse("Password Not Match", false);
            }
        }
        else {
            return new LoginResponse("Email not exist", false);
        }

    }
}

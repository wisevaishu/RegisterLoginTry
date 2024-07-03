package com.example.RegisterLogin.EmployeeController;

import com.example.RegisterLogin.Dto.EmployeeDTO;
import com.example.RegisterLogin.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//@CrossOrigin
@RequestMapping("api/v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public String saveEmployee (@RequestBody EmployeeDTO employeeDTO)
    {
        String id = employeeService.addEmployee(employeeDTO);

        return id;
    }
}

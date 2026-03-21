package vn.fpoly.java5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.fpoly.java5.entity.Employee;
import vn.fpoly.java5.services.EmployeeService;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService = new EmployeeService();
    @GetMapping("/index")
    public String getEmployee(@ModelAttribute("employee") Employee employee, Model model) {
        model.addAttribute("header", "Quản lý nhân sự"); //1. SD phuong thuc addAttribute
        //2. Tao doi tuong tu request va binding voi Model
        model.addAttribute("seachResult", employee);
        List<Employee> employees = employeeService.findByName(employee.getFullName());
        model.addAttribute("employees", employees);
        //3. Binding gia tri tra ve cua phuong thuc vao model
        int total = employeeService.count();
                model.addAttribute("total", total);
        return "employee/index";
    }
}

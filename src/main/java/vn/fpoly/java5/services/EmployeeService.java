package vn.fpoly.java5.services;

import vn.fpoly.java5.entity.Employee;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {
    private final List<Employee> employees = List.of(
      new Employee(1L,"Nguyễn Văn An","hellosangdinh@gmail.com")   ,
      new Employee(2L,"Nguyễn Syfm","syfm@gmail.com")      ,
      new Employee(3L,"Nguyễn Sybau","sythebau@gmail.com")
    );
    public List<Employee> findByName(String name) {
        if (name==null || name.trim().isBlank()) {
            return employees;
        }
        return employees.stream().filter(s->s.getFullName().
                toLowerCase()
                .contains(name.toLowerCase()))
                        .toList();
    }

    public int count(){
        return employees.size();
    }
}

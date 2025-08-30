package org.gs.beans;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
public class EmployeeRepo implements EmployeeService {
    private List<Employee> employees = new ArrayList<>();


    @Override
    public void createEmployee(Employee employee) {
        employees.add(employee);
    }

    @Override
    public Employee readEmployee(int id) {
        return employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void updateEmployee(int id, String name, int age, String department, double salary) {
        Employee employee = employees.stream().filter(e -> e.getId() == id).findFirst().orElse(null);
        if(employee != null){
            employee.setName(name);
            employee.setAge(age);
            employee.setDepartment(department);
            employee.setSalary(salary);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    @Override
    public List<Employee> printAllEmployees(){
        return List.copyOf(employees);
    }

    @Override
    public boolean isExist(int id){
        return employees.stream().anyMatch(e -> e.getId() == id);
    }
}

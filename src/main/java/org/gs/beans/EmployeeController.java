package org.gs.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public void createEmployee(Employee employee){
        if(employeeService.isExist(employee.getId())){
            System.out.println("Employee with id " + employee.getId() + " already exist");
            return;
        }
        employeeService.createEmployee(employee);
    }

    public Employee readEmployee(int id){
        if(!employeeService.isExist(id)){
            System.out.println("Can't read employee cuz he isn't found");
            return null;
        }
        return employeeService.readEmployee(id);
    }

    public void updateEmployee(int id, String name, int age, String department, double salary){
        if(!employeeService.isExist(id)){
            System.out.println("Can't update employee cuz he isn't found");
            return;
        }
        employeeService.updateEmployee(id, name, age, department, salary);
    }

    public void deleteEmployee(int id){
        employeeService.deleteEmployee(id);
    }

    public void printAllEmployees(){
        employeeService.printAllEmployees().forEach(System.out::println);
    }


}

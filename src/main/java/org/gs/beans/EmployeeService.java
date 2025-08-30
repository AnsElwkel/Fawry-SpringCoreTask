package org.gs.beans;


import java.util.List;

public interface EmployeeService {
    void createEmployee(Employee employee);
    Employee readEmployee(int id);
    void updateEmployee(int id, String name, int age, String department, double salary);
    void deleteEmployee(int id);
    List<Employee> printAllEmployees();
    boolean isExist(int id);
}

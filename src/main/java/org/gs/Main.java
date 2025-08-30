package org.gs;

import org.gs.beans.Employee;
import org.gs.beans.EmployeeController;
import org.gs.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        EmployeeController employeeController = context.getBean(EmployeeController.class);

        employeeController.createEmployee(new Employee("Anas" , 1, 20, "IT", 10000));
        employeeController.createEmployee(new Employee("Zaki" , 2, 23, "IT", 10000));
        employeeController.createEmployee(new Employee("Zeyad" , 3, 25, "IT", 10000));
        employeeController.createEmployee(new Employee("Based" , 4, 19, "IT", 10000));
        employeeController.createEmployee(new Employee("Ahmed" , 5, 30, "IT", 10000));

        employeeController.readEmployee(1);
        employeeController.updateEmployee(2, "Mohamed", 20, "IT", 20000);
        employeeController.deleteEmployee(3);
        employeeController.printAllEmployees();
    }
}
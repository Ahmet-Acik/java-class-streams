// EmployeeManager.java
package org.ahmet.classes;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeManager {
    private List<Employee> employees;

    public EmployeeManager(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Employee> filterByDepartment(String department) {
        return employees.stream()
                .filter(employee -> department.equals(employee.getDepartment()))
                .collect(Collectors.toList());
    }

    public List<String> getEmployeeNames() {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public double calculateAverageSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0.0);
    }
}


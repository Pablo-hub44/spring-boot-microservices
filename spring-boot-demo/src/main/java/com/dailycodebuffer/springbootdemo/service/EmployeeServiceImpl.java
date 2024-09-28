package com.dailycodebuffer.springbootdemo.service;

import com.dailycodebuffer.springbootdemo.error.EmployeeNotFoundException;
import com.dailycodebuffer.springbootdemo.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    /**
     * metodo para guardar un mempleado
     */
    @Override
    public Employee save(Employee employee) {

        if (employee.getEmployeeId() == null ||
                employee.getEmailId().isEmpty()) {
            employee.setEmployeeId(UUID.randomUUID().toString());
        }
        employees.add(employee);
        return employee;
    }

    /**
     * metodo para conseguir todos los empleados
     */
    @Override
    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * metodo para conseguir un empleado por su id, sino lazar excption
     * personalizada
     * 
     */
    @Override
    public Employee getEmployeeById(String id) {
        return employees
                .stream()
                .filter(employee -> employee.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("" +
                        "Empleado no encontrado con id: " + id));
    }

    @Override
    public String deleteEmployeeById(String id) {
        Employee employee = employees
                .stream()
                .filter(e -> e.getEmployeeId().equalsIgnoreCase(id))
                .findFirst()
                .get();

        employees.remove(employee);
        return "Employee deleted with the id: " + id;
    }

    @Override
    public Employee getEmployeeByName(String firstName) {
        return employees
                .stream()
                .filter(employee -> employee.getFirstName().equalsIgnoreCase(firstName))
                .findFirst()
                .orElseThrow(() -> new EmployeeNotFoundException("" +
                        "Empleado no encontrado con nombre: " + firstName));
    }
}

package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class EmployeeManagerTest {

    private EmployeeManager employeeManager;

    @BeforeEach
    public void setUp() {
        employeeManager = new EmployeeManager();
    }

    @Test
    public void testInitialEmployeeCount() {
        
        Employees employees = employeeManager.getAllEmployees();
        
        assertNotNull(employees.getEmployeeList());
        
        assert(employees.getEmployeeList().size() >= 3);
    }

    @Test
    public void testAddEmployee() {
        
        Employee newEmp = new Employee("Test-ID", "Test", "User", "test@test.com", "Tester");
        
        
        int initialSize = employeeManager.getAllEmployees().getEmployeeList().size();
        
        
        employeeManager.addEmployee(newEmp);
        
        
        int newSize = employeeManager.getAllEmployees().getEmployeeList().size();
        assertEquals(initialSize + 1, newSize);
    }
}
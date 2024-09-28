package com.dailycodebuffer.springbootdemo.error;

/**
 * clase para hacer excepcion personalizada, exteiende de runtimeexception
 */
public class EmployeeNotFoundException extends RuntimeException {

    // constructor
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}

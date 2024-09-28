package com.dailycodebuffer.springbootdemo.error;

import com.dailycodebuffer.springbootdemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//anotacion q significa que sera comprtido a muchos controllers
@ControllerAdvice
public class RestResponseEntityExceptionHandler
        extends ResponseEntityExceptionHandler {

    /**
     * employeeNotFoundHandler manejador cuando no se encuentre el empleado
     * 
     * @param exception
     * @return ErrorMessage
     */
    @ExceptionHandler(EmployeeNotFoundException.class) // la clase de excepsion
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND) // por default sea not found
    public ErrorMessage employeeNotFoundHandler(EmployeeNotFoundException exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND, exception.getMessage());
        return message;
    }

    /**
     * genericExceptionHandler manejador de excepcion generico
     * 
     * @param exception
     * @return ErrorMessage
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage genericExceptionHandler(Exception exception) {
        ErrorMessage message = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, exception.getMessage());
        return message;
    }
}

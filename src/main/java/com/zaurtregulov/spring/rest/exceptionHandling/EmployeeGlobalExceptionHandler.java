package com.zaurtregulov.spring.rest.exceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //функция global exception handler
public class EmployeeGlobalExceptionHandler {
    @ExceptionHandler //отмечает метод, ответственный за обработку исключений
    //ResponseEntity - это обертка HTTPResponse. Использует generic и мы указываем, что в случае выброса
    //NoSuchEmployeeException мы должны в тело response добавить объект ImployeeIncorrestData.
    //Это тип объекта, который добавляется в Http response body.
    public ResponseEntity<EmployeeIncorrectData> handleException(NoSuchEmployeeException exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeIncorrectData> handleException(Exception exception) {
        EmployeeIncorrectData data = new EmployeeIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}

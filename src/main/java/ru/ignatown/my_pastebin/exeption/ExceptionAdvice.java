package ru.ignatown.my_pastebin.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.ignatown.my_pastebin.entity.ExceptionResponse;

@ControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponse> handleException(IllegalArgumentException e) {
        ExceptionResponse response = new ExceptionResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

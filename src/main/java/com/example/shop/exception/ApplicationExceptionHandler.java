//package com.example.shop.exception;
//
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.context.request.WebRequest;
//
//@ControllerAdvice
//public class ApplicationExceptionHandler {
//
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<?> handleNotFoundException (ResourceNotFoundException ex, WebRequest webRequest){
//        String err = ex.getMessage();
//        ex.printStackTrace();
//        return new ResponseEntity<>("not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<?> handleException (Exception ex, WebRequest webRequest){
//        String err = ex.getMessage();
//        ex.printStackTrace();
//        return new ResponseEntity<>("not found", new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}

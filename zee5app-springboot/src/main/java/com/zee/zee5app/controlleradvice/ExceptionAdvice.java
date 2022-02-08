package com.zee.zee5app.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;

@ControllerAdvice
public class ExceptionAdvice {
// this class shd be used when any userdefined exceptions is called through out all the controller
	
	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsExceptionHandler(){
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Record already exists!!");
		return ResponseEntity.badRequest().body(hashMap);	
	}
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(Exception e){
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Exception :" +e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);	
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(Exception e){
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Unknown Exception : "+ e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);	
	}
	
}

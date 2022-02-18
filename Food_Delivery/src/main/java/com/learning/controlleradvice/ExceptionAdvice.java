package com.learning.controlleradvice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.exception.AlreadyExistsException;
import com.learning.exception.IdNotFoundException;
import com.learning.exception.TypeNotFoundException;
import com.learning.exception.apierror.ApiError;

@ControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {
// this class is used when any userdefined exceptions is called through out all the controller

	@ExceptionHandler(AlreadyExistsException.class)
	public ResponseEntity<?> alreadyExistsExceptionHandler() {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Record already exists!!");
		return ResponseEntity.badRequest().body(hashMap);
	}
	
	@ExceptionHandler(TypeNotFoundException.class)
	public ResponseEntity<?> typeNotFoundExceptionHandler(Exception e) {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Exception :" + e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}

	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<?> idNotFoundExceptionHandler(Exception e) {
		Map<String, String> hashMap = new HashMap<>();
		hashMap.put("message", "Exception :" + e.getMessage());
		return ResponseEntity.badRequest().body(hashMap);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);
		apiError.setMessage("Validation Error!");
		apiError.addValidationErrors(ex.getBindingResult().getFieldErrors());
		apiError.addValidationError(ex.getBindingResult().getGlobalErrors());
		return buildReponseEntity(apiError);
	}

	private ResponseEntity<Object> buildReponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getHttpStatus());
	}

}

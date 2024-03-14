package yahu.in.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import yahu.in.payLoad.ApiResponse;

@RestControllerAdvice //matlab, pure project m kahi bhi exception aaega to yaha handle hoga
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourseNotFoundException (ResourceNotFoundException rx){

		String message = rx.getMessage();
		ApiResponse response = ApiResponse.builder()
											.impMessages(message)
											.seccess(true)
											.status(HttpStatus.NOT_FOUND)
											.build();
		return new ResponseEntity<ApiResponse> (response, HttpStatus.NOT_FOUND);
		
	}
	
}

package yahu.in.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
//	@ExceptionHandler(ResourceNotFoundException.class)
//	public ResponseEntity<ApiResponse> handlerResourseNotFoundException (ResourceNotFoundException rx){
//
//		String message = rx.getMessage();
//		ApiResponse response = ApiResponse.builder()
//											.impMessages(message)
//											.success(true)
//											.status(HttpStatus.NOT_FOUND)
//											.build();
//		return new ResponseEntity<ApiResponse> (response, HttpStatus.NOT_FOUND);
//		
//	}

//or

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> notFoundHandler (ResourceNotFoundException rx){
		Map<String, Object> m = new HashMap<String, Object>();
		m.put("msg", rx.getMessage());
		m.put("success", false);
		m.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(m);
		//here we do not need to create ApiResponse class.
	}
	
}

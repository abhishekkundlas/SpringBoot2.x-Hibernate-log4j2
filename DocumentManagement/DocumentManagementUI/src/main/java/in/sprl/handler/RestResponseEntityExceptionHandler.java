package in.sprl.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		return error(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private <E extends Exception> ResponseEntity<Object> error( final E	exception, final HttpStatus httpStatus) { 		
		return new ResponseEntity<>(new ExceptionJsonInfo(exception), httpStatus);
	}
}
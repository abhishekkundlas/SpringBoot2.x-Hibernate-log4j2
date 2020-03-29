package in.sprl.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	private static final Logger LOCAL_LOGGER = LogManager.getLogger(RestResponseEntityExceptionHandler.class);	
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleExceptions(Exception ex, WebRequest request) {
		
		LOCAL_LOGGER.error (ex.getMessage(), ex.getClass().getSimpleName(), ex);
		return error(ex, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private <E extends Exception> ResponseEntity<Object> error( final E	exception, final HttpStatus httpStatus) { 		
		return new ResponseEntity<>(new ExceptionJsonInfo(exception), httpStatus);
	}
}
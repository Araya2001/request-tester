package aaj.requesttester.handler;

import aaj.requesttester.dto.Error;
import aaj.requesttester.dto.ErrorResponse;
import aaj.requesttester.dto.Status;
import com.mongodb.MongoExecutionTimeoutException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
  //other exception handlers

  @ExceptionHandler(NullPointerException.class)
  protected ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException ex) {
    Status status = Status.ERROR_DOCUMENT_NOT_FOUND;
    Error error = new Error(status);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setError(error);
    return new ResponseEntity<>(errorResponse, status.getHttpStatus());
  }
  @ExceptionHandler(MongoExecutionTimeoutException.class)
  protected ResponseEntity<ErrorResponse> handleMongoExecutionTimeoutExceptionPointerException(MongoExecutionTimeoutException ex) {
    Status status = Status.ERROR_DOCUMENT_NOT_FOUND;
    Error error = new Error(status);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setError(error);
    return new ResponseEntity<>(errorResponse, status.getHttpStatus());
  }

  @ExceptionHandler(IOException.class)
  protected ResponseEntity<ErrorResponse> handleIOException(IOException ex) {
    Status status = Status.ERROR_INTERNAL;
    Error error = new Error(status);
    ErrorResponse errorResponse = new ErrorResponse();
    errorResponse.setError(error);
    return new ResponseEntity<>(errorResponse, status.getHttpStatus());
  }
}
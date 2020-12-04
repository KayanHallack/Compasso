package compasso.backend.handler;

import compasso.backend.exception.GenericException;
import compasso.backend.exception.ClienteNotFoundException;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@Order(1)
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(GenericException.class)
    protected ResponseEntity<ApiError> handleException(GenericException ex) {
        ApiError apiError = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ClienteNotFoundException.class)
    protected ResponseEntity<ApiError> handleException(ClienteNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getLocalizedMessage());
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        List<ValidationError> validationErrors = getMessagesOfField(ex);
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST, validationErrors);

        return new ResponseEntity<>(apiError, status);
    }

    private List<ValidationError> getMessagesOfField(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ValidationError(
                        error.getField(),
                        error.getRejectedValue(),
                        error.getDefaultMessage()
                ))
                .collect(Collectors.toList());
    }
}

package compasso.backend.handler;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiError {

    private HttpStatus httpStatus;
    private String error;
    private List<ValidationError> validationErrors;

    public ApiError(HttpStatus httpStatus,String error) {
        this.httpStatus = httpStatus;
        this.error = error;
    }

    public ApiError(HttpStatus httpStatus, List<ValidationError> validationErrors) {
        this.httpStatus = httpStatus;
        this.validationErrors = validationErrors;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<ValidationError> getValidationErrors() {
        return validationErrors;
    }

    public void setValidationErrors(List<ValidationError> validationErrors) {
        this.validationErrors = validationErrors;
    }
}

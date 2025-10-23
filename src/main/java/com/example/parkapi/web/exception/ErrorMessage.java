package com.example.parkapi.web.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
public class ErrorMessage implements Serializable {

    private String path;
    private String method;
    private int status;
    private String statusText;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Map<String, String> errors;
    public ErrorMessage(){}
    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message){
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.message = message;
    }
    public ErrorMessage(HttpServletRequest request, HttpStatus status, String message, BindingResult result){
        this.path = request.getRequestURI();
        this.method = request.getMethod();
        this.status = status.value();
        this.statusText = status.getReasonPhrase();
        this.message = message;
        addErrors(result); 
    }
    public String getPath() {
        return path;
    }
    public String getMethod() {
        return method;
    }
    public int getStatus() {
        return status;
    }
    public String getStatusText() {
        return statusText;
    }
    public String getMessage() {
        return message;
    }
    public Map<String, String> getErrors() {
        return errors;
    }
    @Override
    public String toString() {
        return "ErrorMessage{" +
                "path='" + path + '\'' +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", statusText='" + statusText + '\'' +
                ", message='" + message + '\'' +
                ", errors=" + errors +
                '}';
    }
    private void addErrors(BindingResult result) {
        this.errors = new HashMap<>();
        for(FieldError fieldError : result.getFieldErrors()){
            this.errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
    }

}

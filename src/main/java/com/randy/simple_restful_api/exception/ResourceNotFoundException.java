package com.randy.simple_restful_api.exception;

import jakarta.validation.ConstraintDeclarationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.Serial;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ConstraintDeclarationException {

    @Serial
    private static final long serialVersionUID = -6141673750216607342L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

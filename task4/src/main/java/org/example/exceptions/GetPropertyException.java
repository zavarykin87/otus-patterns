package org.example.exceptions;


public class GetPropertyException extends Exception {

    private String propName;

    public GetPropertyException(String propName) {
        super(String.format("Property not found: %s", propName));
    }
}

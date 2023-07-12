package com.example.onlineshop.tools.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException {

    public ResourceAlreadyExistsException(String property) {
        super(String.format(
                "User with email: %s already exists." +
                        "Make sure to insert a unique user",
                property));
    }
}

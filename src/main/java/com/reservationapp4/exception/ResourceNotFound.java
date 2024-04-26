package com.reservationapp4.exception;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String s) {
        super(s);
    }
}

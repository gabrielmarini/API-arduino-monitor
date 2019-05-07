package br.com.gmtechnology.api.arduinomonitor.controllers.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public NotFoundException(Throwable throwable) {
        super(throwable);
    }

    public NotFoundException(String message) {
        super(message);
    }
}

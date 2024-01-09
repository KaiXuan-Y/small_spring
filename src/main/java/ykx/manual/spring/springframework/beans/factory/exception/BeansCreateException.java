package ykx.manual.spring.springframework.beans.factory.exception;

public class BeansCreateException extends RuntimeException{
    public BeansCreateException(String message) {
        super(message);
    }

    public BeansCreateException(String message, Throwable cause) {
        super(message, cause);
    }
}

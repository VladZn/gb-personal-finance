package ru.gb.dev.spring.pfs.accounting.exception;

/**
 * @author V. Zinchenko
 */
public class ParameterRequiredException extends RuntimeException {

    public ParameterRequiredException(String message) {
        super(message);
    }
}

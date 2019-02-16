package ru.gb.dev.spring.pfs.accounting.util;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 386726542537970495L;

    public NotFoundException(final String message) {
        super(message);
    }

}

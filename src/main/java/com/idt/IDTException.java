package com.idt;

/**
 * Created by eric on 26/11/16.
 */
public class IDTException extends RuntimeException {

    public IDTException(String message) {
        super(message);
    }

    public IDTException(String message, Exception ex) {
        super(message, ex);
    }
}

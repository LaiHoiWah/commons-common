package com.meowu.commons.common.commons.security.exception;

import java.text.MessageFormat;

public class IllegalArgumentException extends MeowuException{

    public IllegalArgumentException(){
        super();
    }

    public IllegalArgumentException(String message){
        super(message);
    }

    public IllegalArgumentException(Throwable cause){
        super(cause);
    }

    public IllegalArgumentException(String message, Throwable cause){
        super(message, cause);
    }

    public IllegalArgumentException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public IllegalArgumentException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}

package com.meowu.commons.common.commons.security.exception;

import java.text.MessageFormat;

public class ReflectionException extends MeowuException{

    public ReflectionException(){
        super();
    }

    public ReflectionException(String message){
        super(message);
    }

    public ReflectionException(Throwable cause){
        super(cause);
    }

    public ReflectionException(String message, Throwable cause){
        super(message, cause);
    }

    public ReflectionException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public ReflectionException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}

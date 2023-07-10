package com.meowu.commons.common.commons.security.exception;

import java.text.MessageFormat;

public class FieldNotSupportException extends MeowuException{

    public FieldNotSupportException(){
        super();
    }

    public FieldNotSupportException(String message){
        super(message);
    }

    public FieldNotSupportException(Throwable cause){
        super(cause);
    }

    public FieldNotSupportException(String message, Throwable cause){
        super(message, cause);
    }

    public FieldNotSupportException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public FieldNotSupportException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}

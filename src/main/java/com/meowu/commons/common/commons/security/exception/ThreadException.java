package com.meowu.commons.common.commons.security.exception;

import java.text.MessageFormat;

public class ThreadException extends MeowuException{

    public ThreadException(){
        super();
    }

    public ThreadException(String message){
        super(message);
    }

    public ThreadException(Throwable cause){
        super(cause);
    }

    public ThreadException(String message, Throwable cause){
        super(message, cause);
    }

    public ThreadException(String message, Object... args){
        super(MessageFormat.format(message, args));
    }

    public ThreadException(Throwable cause, String message, Object... args){
        super(MessageFormat.format(message, args), cause);
    }
}

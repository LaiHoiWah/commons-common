package com.meowu.commons.common.commons.utils;

import com.meowu.commons.common.commons.security.exception.IllegalArgumentException;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Collection;
import java.util.Map;

public class AssertUtils{

    private AssertUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    //---------- Object ----------//
    public static void isNotNull(Object object, String message){
        if(object == null){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNull(Object object, String message){
        if(object != null){
            throw new IllegalArgumentException(message);
        }
    }

    //---------- Expression ----------//
    public static void isTrue(boolean expression, String message){
        if(!expression){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isFalse(boolean expression, String message){
        if(expression){
            throw new IllegalArgumentException(message);
        }
    }

    //---------- String ----------//
    public static void isNotBlank(CharSequence cs, String message){
        if(StringUtils.isBlank(cs)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isBlank(CharSequence cs, String message){
        if(StringUtils.isNotBlank(cs)){
            throw new IllegalArgumentException(message);
        }
    }

    //---------- Collection ----------//
    public static void isNotEmpty(Collection collection, String message){
        if(CollectionUtils.isEmpty(collection)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(Collection collection, String message){
        if(CollectionUtils.isNotEmpty(collection)){
            throw new IllegalArgumentException(message);
        }
    }

    //---------- Map ----------//
    public static void isNotEmpty(Map map, String message){
        if(map == null || map.isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(Map map, String message){
        if(map != null && !map.isEmpty()){
            throw new IllegalArgumentException(message);
        }
    }

    //---------- Array ----------//
    public static <T> void isNotEmpty(T[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static <T> void isEmpty(T[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(char[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(char[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(byte[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(byte[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(short[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(short[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(int[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(int[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(long[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(long[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(float[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(float[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(double[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(double[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isNotEmpty(boolean[] array, String message){
        if(ArrayUtils.isEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }

    public static void isEmpty(boolean[] array, String message){
        if(ArrayUtils.isNotEmpty(array)){
            throw new IllegalArgumentException(message);
        }
    }
}

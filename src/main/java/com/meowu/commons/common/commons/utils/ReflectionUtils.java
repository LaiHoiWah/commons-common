package com.meowu.commons.common.commons.utils;

import com.meowu.commons.common.commons.security.exception.ReflectionException;
import org.apache.commons.lang3.StringUtils;

import java.beans.Introspector;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.invoke.SerializedLambda;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.function.Function;

public class ReflectionUtils{

    private ReflectionUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static <T, R> Field getField(SerializableFunction<T, R> function){
        AssertUtils.isNotNull(function, "Field getter function must not be null");

        try{
            // get method and set access
            Method method = function.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);

            // serialized method
            SerializedLambda lambda     = (SerializedLambda) method.invoke(function);
            String           methodName = lambda.getImplMethodName();
            String           className  = lambda.getImplClass().replaceAll("/", ".");

            // get file
            String fieldName;

            if(methodName.startsWith("get") && methodName.length() > 3){
                fieldName = Introspector.decapitalize(methodName.substring(3));
            }else if(methodName.startsWith("is") && methodName.length() > 2){
                fieldName = Introspector.decapitalize(methodName.substring(2));
            }else if(methodName.startsWith("lambda$")){
                throw new ReflectionException("Function cannot be lambda function");
            }else{
                throw new ReflectionException("Function is not a getter function");
            }

            return getField(Class.forName(className), fieldName);
        }catch(Exception e){
            throw new ReflectionException(e.getMessage(), e);
        }
    }

    public static Field getField(Class<?> clazz, String fieldName){
        AssertUtils.isNotNull(clazz, "Object class must not be null");
        AssertUtils.isNotBlank(fieldName, "Field name must not be null");

        // get fields
        try{
            return clazz.getDeclaredField(fieldName);
        }catch(NoSuchFieldException e){
            throw new ReflectionException("There is no filed named {0}", fieldName);
        }
    }

    public static <A extends Annotation, T, R> A getAnnotation(SerializableFunction<T, R> function, Class<A> annotationType){
        AssertUtils.isNotNull(function, "Field getter function must not be null");
        AssertUtils.isNotNull(annotationType, "Annotation type must not be null");

        try{
            // get method and set access
            Method method = function.getClass().getDeclaredMethod("writeReplace");
            method.setAccessible(true);

            // get method annotation
            A annotation = method.getDeclaredAnnotation(annotationType);
            if(annotation != null){
                return annotation;
            }

            // serialized method
            SerializedLambda lambda     = (SerializedLambda) method.invoke(function);
            String           methodName = lambda.getImplMethodName();
            String           className  = lambda.getImplClass().replaceAll("/", ".");

            // get field
            String fieldName;

            // if function is getter function
            if(methodName.startsWith("get") && methodName.length() > 3){
                fieldName = Introspector.decapitalize(methodName.substring(3));
            }else if(methodName.startsWith("is") && methodName.length() > 2){
                fieldName = Introspector.decapitalize(methodName.substring(2));
            }else{
                fieldName = null;
            }

            if(StringUtils.isNotBlank(fieldName)){
                Field[] fields = Class.forName(className).getDeclaredFields();

                // search field by name
                for(Field field : fields){
                    if(fieldName.equals(field.getName())){
                        return field.getDeclaredAnnotation(annotationType);
                    }
                }
            }

            return null;
        }catch(Exception e){
            throw new ReflectionException(e.getMessage(), e);
        }
    }

    public static <A extends Annotation> A getAnnotation(Field field, Class<A> annotationType){
        AssertUtils.isNotNull(field, "Field must not be null");
        AssertUtils.isNotNull(annotationType, "Annotation type must not be null");

        return field.getDeclaredAnnotation(annotationType);
    }

    @FunctionalInterface
    public interface SerializableFunction<T, R> extends Function<T, R>, Serializable{

    }
}

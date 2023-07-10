package com.meowu.commons.common.commons.utils;

import com.google.common.base.CaseFormat;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SpellingUtils{

    private static final String EMPTY_STRING = "";

    private SpellingUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String toString(byte[] bytes){
        return toString(bytes, StandardCharsets.UTF_8);
    }

    public static String toString(byte[] bytes, Charset charset){
        AssertUtils.isNotEmpty(bytes, "Bytes array must not be null");
        AssertUtils.isNotNull(charset, "Charset must not be null");

        if(ArrayUtils.isEmpty(bytes)){
            return EMPTY_STRING;
        }

        return new String(bytes, charset);
    }

    public static String upper(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return str.toUpperCase();
    }

    public static String lower(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return str.toLowerCase();
    }

    public static String capitalize(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return StringUtils.capitalize(str);
    }

    public static String uncapitalize(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return StringUtils.uncapitalize(str);
    }

    public static String camel(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
    }

    public static String underline(String str){
        AssertUtils.isNotBlank(str, "String must not be null");

        return CaseFormat.LOWER_CAMEL.to(CaseFormat.LOWER_UNDERSCORE, str);
    }

    public static boolean isEqual(String compare, String compareTo){
        if(compare == compareTo){
            return true;
        }

        if(compare == null || compareTo == null){
            return false;
        }

        int lengthCompare   = compare.length();
        int lengthCompareTo = compareTo.length();

        if(lengthCompareTo == 0){
            return (lengthCompare == 0);
        }

        int result = 0;
        result |= lengthCompare - lengthCompareTo;

        // time-constant comparison
        for(int i = 0; i < lengthCompare; i++){
            // if i >= lengthCompareTo, index is 0; otherwise i
            int index = ((i - lengthCompareTo) >>> 31) * i;
            result |= compare.charAt(i) ^ compareTo.charAt(index);
        }

        return (result == 0);
    }
}

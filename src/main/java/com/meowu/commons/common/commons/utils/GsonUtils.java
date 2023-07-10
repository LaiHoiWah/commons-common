package com.meowu.commons.common.commons.utils;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.Date;

public class GsonUtils{

    private static final Gson GSON = getBuilder().create();

    private GsonUtils(){
        throw new IllegalStateException("Instantiation is not allowed");
    }

    public static String toJson(Object object){
        return GSON.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> classOf){
        AssertUtils.isNotBlank(json, "Json string must not be null");
        AssertUtils.isNotNull(classOf, "Deserialization type must not be null");

        return GSON.fromJson(json, classOf);
    }

    public static <T> T fromJson(String json, Type typeOf){
        AssertUtils.isNotBlank(json, "Json string must not be null");
        AssertUtils.isNotNull(typeOf, "Deserialization type must not be null");

        return GSON.fromJson(json, typeOf);
    }

    public static GsonBuilder getBuilder(){
        return getBuilder(false, true, true);
    }

    public static GsonBuilder getBuilder(boolean serializeNulls, boolean escapeHtmlChars, boolean toTimestamp){
        GsonBuilder builder = new GsonBuilder();

        // settings
        if(serializeNulls){
            builder.serializeNulls();
        }
        if(!escapeHtmlChars){
            builder.disableHtmlEscaping();
        }
        if(toTimestamp){
            builder.registerTypeAdapter(Date.class, new DateSerializer())
                   .registerTypeAdapter(Date.class, new DateDeserializer());
        }

        return builder;
    }

    private static class DateDeserializer implements JsonDeserializer<Date>{
        @Override
        public Date deserialize(JsonElement element, Type typeOf, JsonDeserializationContext context) throws JsonParseException{
            return new Date(element.getAsJsonPrimitive().getAsLong());
        }
    }

    private static class DateSerializer implements JsonSerializer<Date>{
        @Override
        public JsonElement serialize(Date date, Type typeOf, JsonSerializationContext context){
            return new JsonPrimitive(date.getTime());
        }
    }
}

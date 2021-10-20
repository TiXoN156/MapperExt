package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class Mapper {
    public <T> T parse(String str, Class<T> clazz) throws IllegalAccessException, InvocationTargetException,
            InstantiationException {
        String[] split = str.replaceAll("^\\{|\\}$", "").split(",");

        HashMap<String,String> params = new HashMap<>();

        for (int i = 0; i < split.length; i++) {
            params.put(split[i].split(":")[0].trim().replaceAll("^\"|\"$",""),
                    split[i].split(":")[1].trim().replaceAll("^\"|\"$",""));
        }
        return instantiate(params, clazz);
    }

    private <T> T instantiate(HashMap<String, String> params, Class<T> clazz) throws InstantiationException,
            IllegalAccessException, InvocationTargetException {
        T result = null;
        Constructor<?>[] constructors = clazz.getConstructors();
        Object o = constructors[0].newInstance();
        if(clazz.isInstance(o)){
            result = clazz.cast(o);
        }
        Field[] declaredFields = clazz.getDeclaredFields();
        for (int i = 0; i < declaredFields.length; i++) {
            declaredFields[i].setAccessible(true);
            Object field = getField(declaredFields[i], params.get(declaredFields[i].getName()));
            declaredFields[i].set(o, field);
        }
        return result;
    }

    private Object getField(Field field, String value) {

        String fieldType = field.getType().getName().replaceAll("java.lang.", "");
        if (fieldType.equalsIgnoreCase("Integer")) {
            return Integer.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("String")) {
            return value;
        } else if (fieldType.equalsIgnoreCase("Boolean")) {
            return Boolean.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("Byte")) {
            return Byte.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("Long")) {
            return Long.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("Short")) {
            return Short.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("Double")) {
            return Double.valueOf(value);
        } else if (fieldType.equalsIgnoreCase("Float")) {
            return Float.valueOf(value);
        } else {
            return Character.valueOf(value.charAt(0));
        }
    }
}

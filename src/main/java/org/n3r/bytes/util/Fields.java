package org.n3r.bytes.util;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

public class Fields {
    //Returns generic type of any field
    public static Class getFieldGenericType(Field field) {
        if (ParameterizedType.class.isAssignableFrom(field.getGenericType().getClass())) {
            ParameterizedType genericType = (ParameterizedType) field.getGenericType();
            return (Class) genericType.getActualTypeArguments()[0];
        }

        return Void.class;
    }

    public static void setFieldValue(Field field, Object bean, Object value) {
        try {
            field.setAccessible(true);
            field.set(bean, value);
        } catch (Throwable e) {
            throw Throws.propagate(e);
        }
    }

    public static <T> T getFieldValue(Field field, Object bean) {
        try {
            field.setAccessible(true);
            return (T) field.get(bean);
        } catch (Throwable e) {
            throw Throws.propagate(e);
        }

    }
}

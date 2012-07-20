package org.n3r.bytes.impl;

import java.lang.reflect.Field;

import org.n3r.bytes.annotations.BytesTransient;
import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.util.Finds;

import static org.n3r.bytes.util.Bytes.*;

public class DefaultToBytes implements ToBytesAware<Object> {
    private String desc;
    private StringBuilder display;

    @Override
    public String getDesc() {
        return desc != null ? desc : "";
    }

    @Override
    public byte[] toBytes(Object object) {
        Class<?> beanClass = object.getClass();
        ToBytesAware typeToBytes = Finds.findToBytes(beanClass);
        if (typeToBytes != null) {
            byte[] bytes = typeToBytes.toBytes(object);
            desc = typeToBytes.getDesc();
            return bytes;
        }

        byte[] result = new byte[0];
        display = new StringBuilder();

        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(BytesTransient.class) == null) {
                FieldToBytesAware fieldTypeToBytes = Finds.findFieldToBytes(field);
                byte[] bytes = fieldTypeToBytes.toBytes(field, object, display);
                result = add(result, bytes);
            }
        }

        desc = display.toString();

        return result;
    }

}

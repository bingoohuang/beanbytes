package org.n3r.bytes.impl;

import java.lang.reflect.Field;

import org.n3r.bytes.annotations.BytesTransient;
import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.util.Finds;
import org.n3r.bytes.util.Objects;

public class DefaultFromBytes<T> implements FromBytesAware<T> {
    private int offset = 0;

    @Override
    public int getUsedBytesNum() {
        return offset;
    }

    @Override
    public T fromBytes(byte[] bytes, Class<T> beanClass) {
        FromBytesAware bytesToType = Finds.findFromBytes(beanClass);
        if (bytesToType != null) {
            T object = (T) bytesToType.fromBytes(bytes, beanClass);
            offset = bytesToType.getUsedBytesNum();
            return object;
        }

        this.offset = 0;
        T bean = Objects.newInstance(beanClass);

        Field[] declaredFields = beanClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getAnnotation(BytesTransient.class) == null) {
                FieldFromBytesAware fieldBytesToType = Finds.findFieldFromBytes(field);
                offset += fieldBytesToType.fromBytes(field, bean, bytes, offset);
            }
        }

        return bean;
    }

}

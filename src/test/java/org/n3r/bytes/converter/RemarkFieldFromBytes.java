package org.n3r.bytes.converter;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldFromBytesAware;


public class RemarkFieldFromBytes implements FieldFromBytesAware {

    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {
        return 0;
    }

}

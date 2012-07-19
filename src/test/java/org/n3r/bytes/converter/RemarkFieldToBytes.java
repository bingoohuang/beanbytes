package org.n3r.bytes.converter;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldToBytesAware;


public class RemarkFieldToBytes implements FieldToBytesAware {

    @Override
    public byte[] toBytes(Field field, Object person, StringBuilder display) {
        return new byte[0];
    }

}

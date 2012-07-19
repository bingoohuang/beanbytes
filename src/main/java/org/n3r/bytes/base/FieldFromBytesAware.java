package org.n3r.bytes.base;

import java.lang.reflect.Field;

public interface FieldFromBytesAware {
    int fromBytes(Field field, Object bean, byte[] bytes, int offset);
}
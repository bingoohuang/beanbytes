package org.n3r.bytes.base;

import java.lang.reflect.Field;

public interface FieldToBytesAware {

    byte[] toBytes(Field field, Object person, StringBuilder display);

}
package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Fields;

public class ByteFieldFromBytes implements FieldFromBytesAware {

    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {

        Byte b = Bytes.toByte(bytes, offset);

        Fields.setFieldValue(field, bean, b);

        return 1;

    }
}

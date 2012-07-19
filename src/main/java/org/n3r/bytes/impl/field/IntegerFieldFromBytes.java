package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.util.Fields;

import static org.n3r.bytes.util.Bytes.*;

public class IntegerFieldFromBytes implements FieldFromBytesAware {

    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {
        int intValue = toInt(bytes, offset);
        Fields.setFieldValue(field, bean, intValue);
        return 4;
    }
}

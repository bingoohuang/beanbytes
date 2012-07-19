package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.util.Fields;

public class BeanFieldFromBytes implements FieldFromBytesAware {

    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {
        DefaultFromBytes converter = new DefaultFromBytes();
        Object obj = converter.fromBytes(bytes, field.getType());

        Fields.setFieldValue(field, bean, obj);

        return converter.getUsedBytesNum();

    }

}

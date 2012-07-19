package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Descs;
import org.n3r.bytes.util.Fields;

public class BeanFieldToBytes implements FieldToBytesAware {

    @Override
    public byte[] toBytes(Field field, Object bean, StringBuilder display) {
        ToBytesAware toBytes = new DefaultToBytes();
        byte[] bytes = toBytes.toBytes(Fields.getFieldValue(field, bean));

        Descs.addDesc(display, field.getName(), "{" + toBytes.getDesc() + "}");

        return bytes;
    }
}

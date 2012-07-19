package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Fields;

public class ListFieldFromBytes implements FieldFromBytesAware {
    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {
        short size = Bytes.toShort(bytes, offset);
        int thisOffset = offset + 2;
        Class itemClass = Fields.getFieldGenericType(field);
        if (itemClass == Void.class) throw new RuntimeException("Unkown Item Class for field " + field.getName());

        ArrayList list = new ArrayList(size);
        for (short i = 0; i < size; ++i) {
            FromBytesAware fromBytes = new DefaultFromBytes();
            byte[] subBytes = Bytes.subBytes(bytes, thisOffset);
            Object itemObject = fromBytes.fromBytes(subBytes, itemClass);
            list.add(itemObject);

            thisOffset += fromBytes.getUsedBytesNum();
        }

        Fields.setFieldValue(field, bean, list);

        return thisOffset;
    }
}

package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;
import java.util.List;

import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Descs;
import org.n3r.bytes.util.Fields;

public class ListFieldToBytes implements FieldToBytesAware {

    @Override
    public byte[] toBytes(Field field, Object bean, StringBuilder display) {
        List<?> list = Fields.getFieldValue(field, bean);

        short size = (short) (list != null ? list.size() : 0);
        byte[] result = Bytes.toBytes(size);
        if (list != null) {
            Descs.addDesc(display, field.getName(), "[");

            for (Object item : list) {
                DefaultToBytes toBytes = new DefaultToBytes();
                result = Bytes.add(result, toBytes.toBytes(item));
                display.append(toBytes.getDesc()).append(", ");
            }
            if (size > 0) display.replace(display.length() - 2, display.length(), "]");
            else display.append(']');
        }

        return result;
    }
}

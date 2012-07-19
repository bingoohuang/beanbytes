package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import org.n3r.bytes.annotations.BytesNum;
import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Fields;

import static org.n3r.bytes.util.Bytes.*;

public class StringFieldFromBytes implements FieldFromBytesAware {

    @Override
    public int fromBytes(Field field, Object bean, byte[] bytes, int offset) {
        BytesNum jcBytes = field.getAnnotation(BytesNum.class);
        short bytesLen = jcBytes == null ? toShort(bytes, offset) : jcBytes.value();
        int returnOffset = jcBytes == null ? 2 : 0;

        String strValue = Bytes.toString(bytes, offset + returnOffset, bytesLen);

        Fields.setFieldValue(field, bean, strValue);
        return returnOffset + bytesLen;

    }
}

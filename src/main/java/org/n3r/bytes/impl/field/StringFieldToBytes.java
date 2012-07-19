package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import javax.xml.bind.DatatypeConverter;

import org.n3r.bytes.annotations.BytesNum;
import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Descs;
import org.n3r.bytes.util.Fields;
import org.n3r.bytes.util.Utils;

import static org.apache.commons.lang.StringUtils.*;
import static org.n3r.bytes.util.Bytes.*;

public class StringFieldToBytes implements FieldToBytesAware {

    @Override
    public byte[] toBytes(Field field, Object person, StringBuilder display) {
        String fieldValue = Fields.getFieldValue(field, person);
        byte[] fieldBytes = isEmpty(fieldValue) ? new byte[0] : getBytes(fieldValue, Utils.getCharsetName(field));
        short shortLen = (short) fieldBytes.length;
        BytesNum jcBytes = field.getAnnotation(BytesNum.class);
        byte[] lenBytes = jcBytes == null ? Bytes.toBytes(shortLen) : new byte[0];

        Descs.addDesc(display, field.getName(),
                jcBytes != null ? fieldValue : DatatypeConverter.printHexBinary(fieldBytes));

        return add(lenBytes, fieldBytes);
    }

}

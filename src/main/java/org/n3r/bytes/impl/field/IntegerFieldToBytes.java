package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import javax.xml.bind.DatatypeConverter;

import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.util.Bytes;
import org.n3r.bytes.util.Descs;
import org.n3r.bytes.util.Fields;

public class IntegerFieldToBytes implements FieldToBytesAware {
    @Override
    public byte[] toBytes(Field field, Object person, StringBuilder display) {
        int fieldValue = Fields.getFieldValue(field, person);
        byte[] bytes = Bytes.toBytes(fieldValue);

        Descs.addDesc(display, field.getName(), DatatypeConverter.printHexBinary(bytes));

        return bytes;
    }

}

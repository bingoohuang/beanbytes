package org.n3r.bytes.impl.field;

import java.lang.reflect.Field;

import javax.xml.bind.DatatypeConverter;

import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.util.Descs;
import org.n3r.bytes.util.Fields;

public class ByteFieldToBytes implements FieldToBytesAware {

    @Override
    public byte[] toBytes(Field field, Object person, StringBuilder display) {
        Byte b = Fields.getFieldValue(field, person);

        Descs.addDesc(display, field.getName(), DatatypeConverter.printHexBinary(new byte[] { b }));

        return new byte[] { b };
    }

}

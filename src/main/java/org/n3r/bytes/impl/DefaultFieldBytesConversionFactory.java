package org.n3r.bytes.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.n3r.bytes.base.FieldBytesConversionFactory;
import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.impl.field.ByteFieldFromBytes;
import org.n3r.bytes.impl.field.ByteFieldToBytes;
import org.n3r.bytes.impl.field.IntegerFieldFromBytes;
import org.n3r.bytes.impl.field.IntegerFieldToBytes;
import org.n3r.bytes.impl.field.ListFieldFromBytes;
import org.n3r.bytes.impl.field.ListFieldToBytes;
import org.n3r.bytes.impl.field.StringFieldFromBytes;
import org.n3r.bytes.impl.field.StringFieldToBytes;

public class DefaultFieldBytesConversionFactory implements FieldBytesConversionFactory {

    @Override
    public Map<Class<?>, Class<? extends FieldFromBytesAware>> getFieldFromBytesMapping() {
        Map<Class<?>, Class<? extends FieldFromBytesAware>> map = new HashMap<Class<?>, Class<? extends FieldFromBytesAware>>();
        map.put(String.class, StringFieldFromBytes.class);
        map.put(Integer.class, IntegerFieldFromBytes.class);
        map.put(Byte.class, ByteFieldFromBytes.class);
        map.put(List.class, ListFieldFromBytes.class);

        return map;
    }

    @Override
    public Map<Class<?>, Class<? extends FieldToBytesAware>> getFieldToBytesMapping() {
        Map<Class<?>, Class<? extends FieldToBytesAware>> map = new HashMap<Class<?>, Class<? extends FieldToBytesAware>>();
        map.put(String.class, StringFieldToBytes.class);
        map.put(Integer.class, IntegerFieldToBytes.class);
        map.put(Byte.class, ByteFieldToBytes.class);
        map.put(List.class, ListFieldToBytes.class);

        return map;
    }

}

package org.n3r.bytes.impl;

import java.util.HashMap;
import java.util.Map;

import org.n3r.bytes.base.BytesConversionFactory;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.impl.type.StringFromBytes;
import org.n3r.bytes.impl.type.StringToBytes;

public class DefaultBytesConversionFactory implements BytesConversionFactory {

    @Override
    public Map<Class<?>, Class<? extends FromBytesAware>> getFromBytesMapping() {
        Map<Class<?>, Class<? extends FromBytesAware>> map = new HashMap<Class<?>, Class<? extends FromBytesAware>>();
        map.put(String.class, StringFromBytes.class);

        return map;
    }

    @Override
    public Map<Class<?>, Class<? extends ToBytesAware>> getToBytesMapping() {
        Map<Class<?>, Class<? extends ToBytesAware>> map = new HashMap<Class<?>, Class<? extends ToBytesAware>>();
        map.put(String.class, StringToBytes.class);

        return map;
    }
}

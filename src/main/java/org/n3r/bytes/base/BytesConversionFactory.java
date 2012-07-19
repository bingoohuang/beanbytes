package org.n3r.bytes.base;

import java.util.Map;

public interface BytesConversionFactory {
    Map<Class<?>, Class<? extends FromBytesAware>> getFromBytesMapping();

    Map<Class<?>, Class<? extends ToBytesAware>> getToBytesMapping();
}

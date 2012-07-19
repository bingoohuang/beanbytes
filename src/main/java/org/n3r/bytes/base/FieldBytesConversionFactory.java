package org.n3r.bytes.base;

import java.util.Map;

public interface FieldBytesConversionFactory {

    Map<Class<?>, Class<? extends FieldFromBytesAware>> getFieldFromBytesMapping();

    Map<Class<?>, Class<? extends FieldToBytesAware>> getFieldToBytesMapping();

}

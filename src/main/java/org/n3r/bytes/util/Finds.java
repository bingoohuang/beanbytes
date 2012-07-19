package org.n3r.bytes.util;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

import org.apache.commons.lang.ClassUtils;
import org.n3r.bytes.annotations.FromBytesClass;
import org.n3r.bytes.annotations.ToBytesClass;
import org.n3r.bytes.base.BytesConversionFactory;
import org.n3r.bytes.base.FieldBytesConversionFactory;
import org.n3r.bytes.base.FieldFromBytesAware;
import org.n3r.bytes.base.FieldToBytesAware;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.impl.field.BeanFieldFromBytes;
import org.n3r.bytes.impl.field.BeanFieldToBytes;

public class Finds {
    private static Map<Class<?>, Class<? extends FromBytesAware>> fromBytesMapping = new HashMap<Class<?>, Class<? extends FromBytesAware>>();
    private static Map<Class<?>, Class<? extends ToBytesAware>> toBytesMapping = new HashMap<Class<?>, Class<? extends ToBytesAware>>();
    private static Map<Class<?>, Class<? extends FieldFromBytesAware>> fieldFromBytesMapping = new HashMap<Class<?>, Class<? extends FieldFromBytesAware>>();
    private static Map<Class<?>, Class<? extends FieldToBytesAware>> fieldToBytesMapping = new HashMap<Class<?>, Class<? extends FieldToBytesAware>>();
    static {
        ServiceLoader<BytesConversionFactory> factoryLoader = ServiceLoader
                .load(BytesConversionFactory.class);
        for (BytesConversionFactory factory : factoryLoader) {
            fromBytesMapping.putAll(factory.getFromBytesMapping());
            toBytesMapping.putAll(factory.getToBytesMapping());
        }

        ServiceLoader<FieldBytesConversionFactory> fieldFactoryLoader = ServiceLoader
                .load(FieldBytesConversionFactory.class);
        for (FieldBytesConversionFactory factory : fieldFactoryLoader) {
            fieldFromBytesMapping.putAll(factory.getFieldFromBytesMapping());
            fieldToBytesMapping.putAll(factory.getFieldToBytesMapping());
        }
    }

    public static ToBytesAware findToBytes(Class<?> clazz) {
        Class<?> fieldType = ClassUtils.primitiveToWrapper(clazz);
        Class<? extends ToBytesAware> toBytesClass = toBytesMapping.get(fieldType);
        return toBytesClass != null ? Objects.newInstance(toBytesClass) : null;
    }

    public static FromBytesAware findFromBytes(Class<?> clazz) {
        Class<?> fieldType = ClassUtils.primitiveToWrapper(clazz);
        Class<? extends FromBytesAware> fromBytesClass = fromBytesMapping.get(fieldType);

        return fromBytesClass != null ? Objects.newInstance(fromBytesClass) : null;
    }

    public static FieldToBytesAware findFieldToBytes(Field field) {
        ToBytesClass jcTypeToBytes = field.getAnnotation(ToBytesClass.class);
        if (jcTypeToBytes != null) return Objects.newInstance(jcTypeToBytes.value());

        Class<?> fieldType = ClassUtils.primitiveToWrapper(field.getType());
        Class<? extends FieldToBytesAware> fieldToBytesClass = fieldToBytesMapping.get(fieldType);
        return fieldToBytesClass != null ? Objects.newInstance(fieldToBytesClass) : new BeanFieldToBytes();
    }

    public static FieldFromBytesAware findFieldFromBytes(Field field) {
        FromBytesClass jcBytesToType = field.getAnnotation(FromBytesClass.class);
        if (jcBytesToType != null) return Objects.newInstance(jcBytesToType.value());

        Class<?> fieldType = ClassUtils.primitiveToWrapper(field.getType());
        Class<? extends FieldFromBytesAware> fieldFromBytesClass = fieldFromBytesMapping.get(fieldType);
        return fieldFromBytesClass != null ? Objects.newInstance(fieldFromBytesClass) : new BeanFieldFromBytes();
    }

}

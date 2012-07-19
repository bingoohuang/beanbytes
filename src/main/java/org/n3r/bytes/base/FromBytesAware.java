package org.n3r.bytes.base;

public interface FromBytesAware<T> {
    T fromBytes(byte[] bytes, Class<T> beanClass);

    int getUsedBytesNum();
}

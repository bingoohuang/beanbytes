package org.n3r.bytes.base;

public interface ToBytesAware<T> {
    byte[] toBytes(T object);

    String getDesc();
}

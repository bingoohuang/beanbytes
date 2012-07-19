package org.n3r.bytes.util;


public final class Objects {
    public static <T> boolean contains(T value, T[] values) {
        for (T v : values) {
            if (equals(v, value)) { return true; }
        }
        return false;
    }

    public static boolean equals(Object o1, Object o2) {
        return o1 == null ? o2 == null : o1.equals(o2);
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            throw Throws.propagate(e);
        }
    }

    public static <T> T newInstance(String className) {
        try {
            Class<?> clazz = Class.forName(className);
            return (T) newInstance(clazz);
        } catch (Exception e) {
            throw Throws.propagate(e);
        }

    }

    public static boolean existsClass(String className) {
        try {
            Class.forName(className);
            return true;

        } catch (ClassNotFoundException e) {
            return false;
        }
    }

}

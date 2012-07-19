package org.n3r.bytes.util;

import java.lang.reflect.Field;

import org.n3r.bytes.annotations.BytesCharset;

public class Utils {
    public static String getCharsetName(Field field) {
        BytesCharset charset = field.getAnnotation(BytesCharset.class);
        return charset != null ? charset.value() : "UTF-8";
    }
}

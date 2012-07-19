package org.n3r.bytes.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.n3r.bytes.base.FieldFromBytesAware;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FromBytesClass {
    Class<? extends FieldFromBytesAware> value();
}

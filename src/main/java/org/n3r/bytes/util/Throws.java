package org.n3r.bytes.util;

public class Throws {
    public static <X extends Throwable> void propagateIfInstanceOf(
            Throwable throwable, Class<X> declaredType) throws X {
        // Check for null is needed to avoid frequent JNI calls to isInstance().
        if (throwable != null && declaredType.isInstance(throwable)) { throw declaredType.cast(throwable); }
    }

    public static void propagateIfPossible(Throwable throwable) {
        propagateIfInstanceOf(throwable, Error.class);
        propagateIfInstanceOf(throwable, RuntimeException.class);
    }

    public static RuntimeException propagate(Throwable throwable) {
        propagateIfPossible(throwable);
        throw new RuntimeException(throwable);
    }

}

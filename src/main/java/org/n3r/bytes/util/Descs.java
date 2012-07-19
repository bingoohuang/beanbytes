package org.n3r.bytes.util;

public class Descs {
    public static StringBuilder addDesc(StringBuilder display, String name, String desc) {
        display.append(display.length() > 0 ? ", " : "");
        display.append(name).append(':').append(desc);

        return display;
    }
}

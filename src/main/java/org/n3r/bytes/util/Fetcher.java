package org.n3r.bytes.util;

import static org.n3r.bytes.util.Bytes.*;

public class Fetcher {
    private byte[] bytes;
    private int offset;

    public Fetcher(byte[] bytes) {
        this.bytes = bytes;
        this.offset = 0;
    }

    public String getFixedLengthString(int length) {
        byte[] subBytes = new byte[length];
        System.arraycopy(bytes, offset, subBytes, 0, length);
        offset += length;

        return Bytes.toString(subBytes);
    }

    public String getDynamicString() {
        byte[] nameBytesLen = subBytes(bytes, offset, 2);
        short len = toShort(nameBytesLen);
        byte[] nameBytes = subBytes(bytes, offset + 2, len);

        offset += 2 + len;

        return Bytes.toString(nameBytes);
    }

    public int getInt() {
        int ret = Bytes.toInt(bytes, offset);
        offset += 4;

        return ret;
    }

    public byte getByte() {
        return bytes[offset++];
    }

}

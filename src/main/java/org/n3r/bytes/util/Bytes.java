package org.n3r.bytes.util;

import java.io.UnsupportedEncodingException;

import javax.xml.bind.DatatypeConverter;

public class Bytes {
    public static String toBase64(byte[] bytes) {
        return DatatypeConverter.printBase64Binary(bytes);
    }

    public static byte[] fromBase64(String str) {
        return DatatypeConverter.parseBase64Binary(str);
    }

    public static String toHex(byte[] bytes) {
        return DatatypeConverter.printHexBinary(bytes);
    }

    public static byte[] fromHex(String str) {
        return DatatypeConverter.parseHexBinary(str);
    }

    public static byte[] getBytes(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw Throws.propagate(e);
        }
    }

    public static byte[] getBytes(String str, String charsetName) {
        try {
            return str.getBytes(charsetName);
        } catch (UnsupportedEncodingException e) {
            throw Throws.propagate(e);
        }
    }

    public static String toString(final byte[] b) {
        return toString(b, 0, b.length, "UTF-8");
    }

    public static String toString(final byte[] b, int off, int len) {
        return toString(b, off, len, "UTF-8");
    }

    public static String toString(final byte[] b, int off, int len, String charsetName) {
        try {
            return new String(b, off, len, charsetName);
        } catch (Exception e) {
            throw Throws.propagate(e);
        }
    }

    public static byte[] subBytes(final byte[] src, int offset) {
        int length = src.length - offset;
        byte[] result = new byte[length];
        System.arraycopy(src, offset, result, 0, length);
        return result;
    }

    public static byte[] subBytes(final byte[] src, int offset, int length) {
        byte[] result = new byte[length];
        System.arraycopy(src, offset, result, 0, length);
        return result;
    }

    public static byte[] add(final byte[] a, final byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }

    public static byte[] add(final byte[] a, final byte[] b, final byte[] c) {
        byte[] result = new byte[a.length + b.length + c.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.arraycopy(c, 0, result, a.length + b.length, c.length);
        return result;
    }

    public static byte[] toBytes(int val) {
        byte[] b = new byte[4];
        for (int i = 3; i > 0; i--) {
            b[i] = (byte) val;
            val >>>= 8;
        }
        b[0] = (byte) val;
        return b;
    }

    public static byte[] toBytes(short val) {
        byte[] b = new byte[2];
        b[1] = (byte) val;
        val >>= 8;
        b[0] = (byte) val;
        return b;
    }

    /**
     * Converts a byte array to a short value
     * @param bytes byte array
     * @return the short value
     */
    public static short toShort(byte[] bytes) {
        return toShort(bytes, 0, 2);
    }

    /**
     * Converts a byte array to a short value
     * @param bytes byte array
     * @param offset offset into array
     * @return the short value
     */
    public static short toShort(byte[] bytes, int offset) {
        return toShort(bytes, offset, 2);
    }

    /**
     * Converts a byte array to a short value
     * @param bytes byte array
     * @param offset offset into array
     * @param length length, has to be {@link #2}
     * @return the short value
     * @throws IllegalArgumentException if length is not {@link #2}
     * or if there's not enough room in the array at the offset indicated.
     */
    public static short toShort(byte[] bytes, int offset, final int length) {
        short n = 0;
        n ^= bytes[offset] & 0xFF;
        n <<= 8;
        n ^= bytes[offset + 1] & 0xFF;
        return n;
    }

    /**
     * Converts a byte array to an int value
     * @param bytes byte array
     * @return the int value
     */
    public static int toInt(byte[] bytes) {
        return toInt(bytes, 0, 4);
    }

    /**
     * Converts a byte array to an int value
     * @param bytes byte array
     * @param offset offset into array
     * @return the int value
     */
    public static int toInt(byte[] bytes, int offset) {
        return toInt(bytes, offset, 4);
    }

    /**
     * Converts a byte array to an int value
     * @param bytes byte array
     * @param offset offset into array
     * @param length length of int (has to be {@link #4})
     * @return the int value
     * @throws IllegalArgumentException if length is not {@link #4} or
     * if there's not enough room in the array at the offset indicated.
     */
    public static int toInt(byte[] bytes, int offset, final int length) {
        int n = 0;
        for (int i = offset; i < offset + length; i++) {
            n <<= 8;
            n ^= bytes[i] & 0xFF;
        }
        return n;
    }

    public static Byte toByte(byte[] bytes, int offset) {
        return bytes[offset];
    }
}

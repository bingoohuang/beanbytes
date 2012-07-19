package org.n3r.bytes.impl.type;

import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.util.Bytes;

import static org.n3r.bytes.util.Bytes.*;

public class StringFromBytes implements FromBytesAware<String> {

    private int usedBytesNum;

    @Override
    public String fromBytes(byte[] bytes, Class<String> beanClass) {
        short len = toShort(bytes);
        usedBytesNum = 2 + len;

        return Bytes.toString(bytes, 2, len);
    }

    @Override
    public int getUsedBytesNum() {
        return usedBytesNum;
    }

}

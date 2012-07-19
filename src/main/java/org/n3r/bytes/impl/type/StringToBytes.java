package org.n3r.bytes.impl.type;

import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.util.Bytes;

import static org.apache.commons.lang.StringUtils.*;
import static org.n3r.bytes.util.Bytes.*;

public class StringToBytes implements ToBytesAware<String> {

    private String desc;

    @Override
    public byte[] toBytes(String object) {
        this.desc = object;
        byte[] bytes = isEmpty(object) ? new byte[0] : getBytes(object);
        short shortLen = (short) bytes.length;
        byte[] lenBytes = Bytes.toBytes(shortLen);

        return Bytes.add(lenBytes, bytes);
    }

    @Override
    public String getDesc() {
        return desc;
    }

}

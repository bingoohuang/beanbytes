package org.n3r.bytes;

import org.junit.Test;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.bean.UnicodePerson;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Bytes;

import static org.junit.Assert.*;

public class UnicodePersonTest {
    @Test
    public void test1() {
        UnicodePerson unicodePerson = new UnicodePerson();
        String address = "中华人民共和国";
        unicodePerson.setAddress(address);

        ToBytesAware toBytes = new DefaultToBytes();

        byte[] bytes = toBytes.toBytes(unicodePerson);
        System.out.println(toBytes.getDesc());
        assertArrayEquals(Bytes.getBytes(address, "UTF-16"), Bytes.subBytes(bytes, 2));

        FromBytesAware<UnicodePerson> fromBytes = new DefaultFromBytes<UnicodePerson>();
        UnicodePerson unicodePerson2 = fromBytes.fromBytes(bytes, UnicodePerson.class);

        assertEquals(address, unicodePerson2.getAddress());
    }
}

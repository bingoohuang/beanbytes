package org.n3r.bytes;

import org.junit.Test;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.bean.SimplePerson;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Fetcher;

import static org.junit.Assert.*;

public class SimplePersonTest {
    @Test
    public void test1() throws Exception {
        SimplePerson person = new SimplePerson();
        String myid = "341825199013040318";
        person.setId(myid);
        String myname = "BingooHuang";

        person.setName(myname);
        int myage = 32;
        person.setAge(myage);
        person.setRemark("TestCases");
        person.setType((byte) 2);

        ToBytesAware toBytes = new DefaultToBytes();

        byte[] bytes = toBytes.toBytes(person);
        assertEquals("id:341825199013040318, name:42696E676F6F4875616E67, age:00000020, type:02", toBytes.getDesc());

        Fetcher bytesFetch = new Fetcher(bytes);
        assertEquals(myid, bytesFetch.getFixedLengthString(18));
        assertEquals(myname, bytesFetch.getDynamicString());
        assertEquals(myage, bytesFetch.getInt());

        FromBytesAware<SimplePerson> jcConverter = new DefaultFromBytes<SimplePerson>();
        SimplePerson person2 = jcConverter.fromBytes(bytes, SimplePerson.class);
        assertEquals(person, person2);
    }

}

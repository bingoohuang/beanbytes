package org.n3r.bytes;

import org.junit.Test;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.bean.Person;
import org.n3r.bytes.bean.SimplePerson;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Fetcher;

import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void test() throws Exception {
        Person person = new Person();

        SimplePerson simple = new SimplePerson();
        String myid = "342825397313013218";
        simple.setId(myid);
        String myname = "BingooHuang";

        simple.setName(myname);
        int myage = 32;
        simple.setAge(myage);
        simple.setRemark("TestCases");

        person.setSimplePerson(simple);
        person.setAddress("SouthRoad");

        ToBytesAware toBytes = new DefaultToBytes();

        byte[] bytes = toBytes.toBytes(person);
        assertEquals("simplePerson:{id:342825397313013218, name:42696E676F6F4875616E67, age:00000020, type:00}," +
                " address:536F757468526F6164",
                toBytes.getDesc());

        Fetcher bytesFetch = new Fetcher(bytes);
        assertEquals(myid, bytesFetch.getFixedLengthString(18));
        assertEquals(myname, bytesFetch.getDynamicString());
        assertEquals(myage, bytesFetch.getInt());
        bytesFetch.getByte();
        assertEquals("SouthRoad", bytesFetch.getDynamicString());

        FromBytesAware<Person> fromBytes = new DefaultFromBytes<Person>();
        Person person2 = fromBytes.fromBytes(bytes, Person.class);
        assertEquals(simple, person2.getSimplePerson());
        assertEquals("SouthRoad", person2.getAddress());
    }
}

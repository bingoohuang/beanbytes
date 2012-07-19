package org.n3r.bytes;

import java.util.Arrays;

import org.junit.Test;
import org.n3r.bytes.base.FromBytesAware;
import org.n3r.bytes.base.ToBytesAware;
import org.n3r.bytes.bean.Student;
import org.n3r.bytes.impl.DefaultFromBytes;
import org.n3r.bytes.impl.DefaultToBytes;
import org.n3r.bytes.util.Fetcher;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void test1() {
        Student student = new Student();
        student.setName("Wuhc");
        student.setBooks(Arrays.asList("Chinese", "Math"));

        ToBytesAware defaultJCToBytes = new DefaultToBytes();
        byte[] bytes = defaultJCToBytes.toBytes(student);

        Fetcher bytesFetch = new Fetcher(bytes);
        String name = bytesFetch.getDynamicString();
        assertEquals("Wuhc", name);

        FromBytesAware<Student> fromBytes = new DefaultFromBytes<Student>();
        Student student2 = fromBytes.fromBytes(bytes, Student.class);
        assertEquals("Wuhc", student2.getName());
        assertEquals("[Chinese, Math]", student2.getBooks().toString());
    }

    @Test
    public void test2() {
        Student student = new Student();
        student.setName("Wuhc");

        ToBytesAware defaultJCToBytes = new DefaultToBytes();
        byte[] bytes = defaultJCToBytes.toBytes(student);

        Fetcher bytesFetch = new Fetcher(bytes);
        String name = bytesFetch.getDynamicString();
        assertEquals("Wuhc", name);

        FromBytesAware<Student> fromBytes = new DefaultFromBytes<Student>();
        Student student2 = fromBytes.fromBytes(bytes, Student.class);
        assertEquals("Wuhc", student2.getName());
        assertEquals(0, student2.getBooks().size());
    }

    @Test
    public void test3() {
        Student student = new Student();

        ToBytesAware defaultJCToBytes = new DefaultToBytes();
        byte[] bytes = defaultJCToBytes.toBytes(student);

        Fetcher bytesFetch = new Fetcher(bytes);
        String name = bytesFetch.getDynamicString();
        assertEquals("", name);

        FromBytesAware<Student> fromBytes = new DefaultFromBytes<Student>();
        Student student2 = fromBytes.fromBytes(bytes, Student.class);
        assertEquals("", student2.getName());
        assertEquals(0, student2.getBooks().size());
    }
}

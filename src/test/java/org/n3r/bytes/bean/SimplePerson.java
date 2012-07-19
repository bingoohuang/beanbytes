package org.n3r.bytes.bean;

import org.n3r.bytes.annotations.BytesNum;
import org.n3r.bytes.annotations.BytesTransient;
import org.n3r.bytes.annotations.FromBytesClass;
import org.n3r.bytes.annotations.ToBytesClass;
import org.n3r.bytes.converter.RemarkFieldFromBytes;
import org.n3r.bytes.converter.RemarkFieldToBytes;

public class SimplePerson {
    /**
     * 18位身份证。
     */
    @BytesNum(18)
    private String id;
    private String name;
    private int age;
    @ToBytesClass(RemarkFieldToBytes.class)
    @FromBytesClass(RemarkFieldFromBytes.class)
    private String remark;
    @BytesTransient
    private String note;
    private byte type;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + age;
        result = prime * result + (id == null ? 0 : id.hashCode());
        result = prime * result + (name == null ? 0 : name.hashCode());
        result = prime * result + type;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        SimplePerson other = (SimplePerson) obj;
        if (age != other.age) return false;
        if (id == null) {
            if (other.id != null) return false;
        } else if (!id.equals(other.id)) return false;
        if (name == null) {
            if (other.name != null) return false;
        } else if (!name.equals(other.name)) return false;
        if (type != other.type) return false;
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }
}

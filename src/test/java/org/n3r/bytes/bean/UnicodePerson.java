package org.n3r.bytes.bean;

import org.n3r.bytes.annotations.BytesCharset;

public class UnicodePerson {
    @BytesCharset("UTF-16BE")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

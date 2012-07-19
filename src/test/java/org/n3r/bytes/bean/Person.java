package org.n3r.bytes.bean;

public class Person {
    private SimplePerson simplePerson;
    private String address;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (address == null ? 0 : address.hashCode());
        result = prime * result + (simplePerson == null ? 0 : simplePerson.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        if (address == null) {
            if (other.address != null) return false;
        } else if (!address.equals(other.address)) return false;
        if (simplePerson == null) {
            if (other.simplePerson != null) return false;
        } else if (!simplePerson.equals(other.simplePerson)) return false;
        return true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SimplePerson getSimplePerson() {
        return simplePerson;
    }

    public void setSimplePerson(SimplePerson simplePerson) {
        this.simplePerson = simplePerson;
    }
}

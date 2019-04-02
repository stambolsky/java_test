package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private final String id;
    private final String firstname;
    private final String lastname;
    private final String phone_home;
    private final String phone_mobile;
    private final String phone_work;
    private final String email1;
    private final String email2;
    private final String email3;
    private String group;

    public ContactData(String firstname, String lastname, String phone_home, String phone_mobile, String phone_work, String email1, String email2, String email3, String group) {
        this.id = null;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_home = phone_home;
        this.phone_mobile = phone_mobile;
        this.phone_work = phone_work;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.group = group;
    }

    public ContactData(String id, String firstname, String lastname, String phone_home, String phone_mobile, String phone_work, String email1, String email2, String email3, String group) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_home = phone_home;
        this.phone_mobile = phone_mobile;
        this.phone_work = phone_work;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone_home() {
        return phone_home;
    }

    public String getPhone_mobile() {
        return phone_mobile;
    }

    public String getPhone_work() {
        return phone_work;
    }

    public String getEmail1() {
        return email1;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public String getGroup() {
        return group;
    }

}

package ru.stqa.pft.addressbook.model;

public class ContactData {
    private final String firstname;
    private final String lastname;
    private final String phone_home;
    private final String phone_mobile;
    private final String phone_work;
    private final String email1;
    private final String email2;
    private final String email3;

    public ContactData(String firstname, String lastname, String phone_home, String phone_mobile, String phone_work, String email1, String email2, String email3) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone_home = phone_home;
        this.phone_mobile = phone_mobile;
        this.phone_work = phone_work;
        this.email1 = email1;
        this.email2 = email2;
        this.email3 = email3;
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
}

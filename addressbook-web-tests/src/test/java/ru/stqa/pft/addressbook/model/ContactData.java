package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
@XStreamAlias("group")
public class ContactData {

    @Id
    @Column(name = "id")
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;

    @Column(name = "firstname")
    @Expose
    private String firstname;

    @Column(name = "lastname")
    @Expose
    private String lastname;

    @Column(name = "home")
    @Type(type = "text")
    @Expose
    private String phone_home;

    @Column(name = "mobile")
    @Type(type = "text")
    @Expose
    private String phone_mobile;

    @Column(name = "work")
    @Type(type = "text")
    @Expose
    private String phone_work;

    @Column(name = "email")
    @Type(type = "text")
    @Expose
    private String email1;

    @Column(name = "email2")
    @Type(type = "text")
    @Expose
    private String email2;

    @Column(name = "email3")
    @Type(type = "text")
    @Expose
    private String email3;

    @Transient
    private String group;

    @Transient
    private String allPhones;

    @Transient
    private String allEmails;

    @Column(name = "address")
    @Type(type = "text")
    private String address;

    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactData withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactData withPhone_home(String phone_home) {
        this.phone_home = phone_home;
        return this;
    }

    public ContactData withPhone_mobile(String phone_mobile) {
        this.phone_mobile = phone_mobile;
        return this;
    }

    public ContactData withPhone_work(String phone_work) {
        this.phone_work = phone_work;
        return this;
    }

    public ContactData withEmail1(String email1) {
        this.email1 = email1;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo.getPath();
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getId() {
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

    public String getAllPhones() {
        return allPhones;
    }


    public String getAllEmails() {
        return allEmails;
    }

    public String getAddress() {
        return address;
    }

    public File getPhoto() {
        return new File(photo);
    }


}

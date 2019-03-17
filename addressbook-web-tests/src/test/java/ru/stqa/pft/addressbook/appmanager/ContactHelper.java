package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//form/input[21]"));
    }

    public void fillContactForm(ContactData contactData) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getPhone_home());
        type(By.name("mobile"), contactData.getPhone_mobile());
        type(By.name("work"), contactData.getPhone_work());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
    }

    public void deletedContact() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void selectContact() {
        click(By.name("selected[]"));
    }

    public void initContactModification() {
        click(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[8]/a"));
    }

    public void submitContactModification() {
        click(By.xpath("//*[@id=\"content\"]/form[1]/input[22]"));
    }

    public void alertAccept() {
        wd.switchTo().alert().accept();
    }
}

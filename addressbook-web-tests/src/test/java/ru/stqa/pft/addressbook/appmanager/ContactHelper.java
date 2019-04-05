package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void submitContactCreation() {
        click(By.xpath("//form/input[21]"));
    }

    public void fillContactForm(ContactData contactData, boolean creation) {
        type(By.name("firstname"), contactData.getFirstname());
        type(By.name("lastname"), contactData.getLastname());
        type(By.name("home"), contactData.getPhone_home());
        type(By.name("mobile"), contactData.getPhone_mobile());
        type(By.name("work"), contactData.getPhone_work());
        type(By.name("email"), contactData.getEmail1());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        if (creation) {
            new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
        } else {
            Assert.assertFalse(isElementPresent(By.name("new_group")));
        }
    }

    public void deletedContact() {
        click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
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

    public void returnToHomePage() {
        wd.findElement(By.linkText("home page")).click();
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void create(ContactData contact, boolean creation) {
        initContactCreation();
        fillContactForm(contact, creation);
        submitContactCreation();
        contactCache = null;
        returnToHomePage();
    }

    public void modify(ContactData contact) {
        initContactModification();
        fillContactForm(contact, false);
        submitContactModification();
        contactCache = null;
        goToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deletedContact();
        alertAccept();
        contactCache = null;
        goToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCache = null;

    public Contacts all() {
        if (contactCache != null) {
            return new Contacts(contactCache);
        }
        contactCache = new Contacts();
        List<WebElement> elements = wd.findElements(By.cssSelector("tbody > tr[name='entry']"));
        //elements.remove(0);
        for (WebElement element : elements) {
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
            String firstname = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
            String allEmail = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
            String allPhone = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
            String[] emails = allEmail.split("\n");
            String[] phones = allPhone.split("\n");

            contactCache.add(new ContactData().withId(id).withFirstname(firstname).withLastname(lastname)
                    .withEmail1(emails[0]).withEmail2(emails[1]).withEmail3(emails[2])
                    .withPhone_home(phones[0]).withPhone_mobile(phones[1]).withPhone_work(phones[2]));
        }
        return new Contacts(contactCache);
    }

    public void goToHomePage() {
        if (isElementPresent(By.id("maintable"))) {
            return;
        }
        click(By.linkText("home"));
    }

    public ContactData infoFromEditForm(ContactData contact) {
        initContactModificationById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String email1 = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");

        wd.navigate().back();
        return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withPhone_home(home).withPhone_mobile(mobile).withPhone_work(work)
                .withEmail1(email1).withEmail2(email2).withEmail3(email3);
    }

    private void initContactModificationById(int id) {
        WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
        WebElement row = checkbox.findElement(By.xpath("./../.."));
        List<WebElement> cells = row.findElements(By.tagName("td"));
        cells.get(7).findElement(By.tagName("a")).click();

        //wd.findElement(By.xpath(String.format("//input[@value='%s']/../../td[8]/a", id))).click();
        //wd.findElement(By.xpath(String.format("//tr[.//input[@value='%s']]/td[8]/a", id))).click();
        //wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();

    }



    /*public String getIdContact() {
        return wd.findElement(By.xpath("//*[@id=\"maintable\"]/tbody/tr[2]/td[1]/input")).getAttribute("value");
    }

    public void removeIdForModification(List<ContactData> before, int id) {
        for (int i = 0; before.size() > i; i++) {
            if (before.get(i).getId() == id) {
                before.remove(before.get(i));
            }
        }
    }*/

}

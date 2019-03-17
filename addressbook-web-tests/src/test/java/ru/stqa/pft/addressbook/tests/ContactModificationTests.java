package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        app.getContactHelper().initContactModification();
        app.getContactHelper().fillContactForm(new ContactData("SiarheiNew", "TambolskiNew", "111111111", "22222222", "3333333", "test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToContactPage();
    }
}
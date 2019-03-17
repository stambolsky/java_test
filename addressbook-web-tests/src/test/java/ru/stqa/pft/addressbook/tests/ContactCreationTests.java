package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.TestBase;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().goToContactPage();
        app.getContactHelper().fillContactForm(new ContactData("Siarhei", "Tambolski", "111111111", "22222222", "3333333", "test@test.ru", "test2@test.ru", "test3@test.ru"));
        app.getContactHelper().submitContactCreation();
        app.returnToHomePage();

    }

}

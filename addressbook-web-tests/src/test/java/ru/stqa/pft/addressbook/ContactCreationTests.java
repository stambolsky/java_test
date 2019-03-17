package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        goToContactPage();
        fillContactForm(new ContactData("Siarhei", "Tambolski", "111111111", "22222222", "3333333", "test@test.ru", "test2@test.ru", "test3@test.ru"));
        submitContactCreation();
        returnToHomePage();

    }

}

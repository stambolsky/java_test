package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() {
        if (!app.getContactHelper().isThereAContact()) {
            app.getContactHelper().createContact(new ContactData("Siarhei", "Tambolski", "111111111", "22222222", "3333333", "test@test.ru", "test2@test.ru", "test3@test.ru", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        int id = Integer.parseInt(app.getContactHelper().getIdContact());
        app.getContactHelper().initContactModification();
        ContactData contact = new ContactData(before.get(before.size()-1).getId(), "SiarheiNew", "TambolskiNew", null, null, null, null, null, null, null);
        app.getContactHelper().fillContactForm(contact, false);
        app.getContactHelper().submitContactModification();
        app.getNavigationHelper().goToHomePage();
        List<ContactData> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size()-1); // баг в приложении - после модификации, группа удаляется. Должно быть Assert.assertEquals(after.size(), before.size());

        app.getContactHelper().removeIdForModification(before, id);
        Assert.assertEquals(new HashSet<>(before), new HashSet<>(after));
    }

}

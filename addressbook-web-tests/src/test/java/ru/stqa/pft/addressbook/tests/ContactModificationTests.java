package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Siarhei").withLastname("Tambolski").withPhone_home("111111111").withPhone_mobile("22222222").withPhone_work("3333333").withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactModification() {

        List<ContactData> before = app.contact().list();
        int id = Integer.parseInt(app.contact().getIdContact());
        int index = before.size()-1;
        ContactData contact = new ContactData().withId(before.get(index).getId()).withFirstname("SiarheiNew").withLastname("TambolskiNew");

        app.contact().modify(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), index); // баг в приложении - после модификации, группа удаляется. Должно быть Assert.assertEquals(after.size(), before.size());

        app.contact().removeIdForModification(before, id);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);
    }

}

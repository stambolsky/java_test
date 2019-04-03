package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Siarhei").withLastname("Tambolski").withPhone_home("111111111").withPhone_mobile("22222222").withPhone_work("3333333").withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactDeletion() throws Exception {

        List<ContactData> before = app.contact().list();
        int index = before.size() - 1;
        app.contact().delete(index);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() - 1);

        before.remove(index);
        Assert.assertEquals(before, after);
    }


}

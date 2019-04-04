package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import java.util.Comparator;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("Siarhei12").withLastname("Tambolski").withPhone_home("111111111").withPhone_mobile("22222222").withPhone_work("3333333").withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(),equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId()))));

    }

}

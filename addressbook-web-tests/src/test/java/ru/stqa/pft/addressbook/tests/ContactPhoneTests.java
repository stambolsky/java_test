package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;
import ru.stqa.pft.addressbook.model.ContactData;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
            app.contact().create(new ContactData().withFirstname("Siarhei").withLastname("Tambolski").withPhone_home("111111111").withPhone_mobile("22222222").withPhone_work("3333333").withEmail1("test@test.ru").withEmail2("test2@test.ru").withEmail3("test3@test.ru").withGroup("test1"), true);
        }
    }

    @Test
    public void testContactPhones() {
        app.contact().goToHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getEmail1(), equalTo(contactInfoFromEditForm.getEmail1()));
        assertThat(contact.getEmail2(), equalTo(contactInfoFromEditForm.getEmail2()));
        assertThat(contact.getEmail3(), equalTo(contactInfoFromEditForm.getEmail3()));

        assertThat(contact.getPhone_home(), equalTo(cleaned(contactInfoFromEditForm.getPhone_home())));
        assertThat(contact.getPhone_mobile(), equalTo(cleaned(contactInfoFromEditForm.getPhone_mobile())));
        assertThat(contact.getPhone_work(), equalTo(cleaned(contactInfoFromEditForm.getPhone_work())));
    }

    public String cleaned(String phone) {
        return phone.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}

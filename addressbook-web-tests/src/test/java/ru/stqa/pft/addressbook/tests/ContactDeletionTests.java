package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.TestBase;

public class ContactDeletionTests extends TestBase {

    @Test
    public void testContactDeletion() throws Exception {
        app.getContactHelper().selectContact();
        app.getContactHelper().deletedContact();
        app.getNavigationHelper().goToHomePage();
    }

}

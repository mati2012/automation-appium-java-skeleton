package android;

import android.pages.ContactHomePage;
import android.pages.CreateContactPage;
import android.pages.ProfileContactPage;
import android.utils.ContactsAndroidModel;
import org.junit.Test;
import utils.DriverSetup;

import java.util.ArrayList;

public class TestContactsApp extends DriverSetup {

    @Test
    public void testAddNewContact() {
        ContactsAndroidModel contactInfo = new ContactsAndroidModel();

        ContactHomePage contactHomePage = new ContactHomePage();
        CreateContactPage createContactPage = contactHomePage.goToCreateNewContact();

        contactHomePage = createContactPage.saveNewContactInfo(contactInfo);
        String contactFullName = contactInfo.getFullName();

        contactHomePage.searchContact(contactFullName);
        ProfileContactPage profileContactPage = contactHomePage.goToProfileContactView();

        ArrayList<String> expectedContactInfo = contactInfo.getFullContactInfo();
        ArrayList<String> actualContactInfo = profileContactPage.getStoredContactInfo();


    }
}

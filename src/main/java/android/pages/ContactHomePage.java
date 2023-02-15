package android.pages;

import org.openqa.selenium.By;

public class ContactHomePage extends BasePage {

    private final By openSearchContactBar = By.id("com.google.android.dialer:id/open_search_bar");
    private final By searchContactInput = By.id("com.google.android.dialer:id/open_search_view_edit_text");
    private final By createNewContactButton = By.xpath("//android.widget.TextView[@text='Create new contact']");
    private final By contactListItem = By.id("com.google.android.dialer:id/contact_header");
    private final By dismissPopUpButton = By.id("com.google.android.dialer:id/location_permission_dismiss");
    private final By contactsTabButton = By.xpath("//android.view.ViewGroup/android.widget.TextView[@text='Contacts']");

    public CreateContactPage goToCreateNewContact() {
        tapOn(contactsTabButton);
        tapOn(createNewContactButton);
        return new CreateContactPage();
    }

    public void acceptContactInfoLocationPopUp() {
        waitFor(dismissPopUpButton);
        tapOn(dismissPopUpButton);
    }

    public void searchContact(String contactName) {
        waitFor(openSearchContactBar);
        tapOn(openSearchContactBar);
        acceptContactInfoLocationPopUp();
        waitFor(searchContactInput);
        writeIn(searchContactInput, contactName);
    }


    public ProfileContactPage goToProfileContactView() {
        waitFor(contactListItem);
        tapOn(contactListItem);
        return new ProfileContactPage();
    }
}

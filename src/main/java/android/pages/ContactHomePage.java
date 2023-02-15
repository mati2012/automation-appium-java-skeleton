package android.pages;

import org.openqa.selenium.By;

public class ContactHomePage extends BasePage {

    private final By openSearchContactBar = By.id("com.google.android.dialer:id/open_search_bar");
    private final By searchContactInput = By.id("com.google.android.dialer:id/open_search_view_edit_text");
    private final By createNewContactButton = By.xpath("//android.widget.TextView[@text='Create new contact']");
    private final By contactListItem = By.xpath("//android.widget.LinearLayout/android.widget.TextView");

    public CreateContactPage goToCreateNewContact() {
        tapOn(createNewContactButton);
        return new CreateContactPage();
    }

    public void searchContact(String contactName) {
        waitFor(openSearchContactBar);
        tapOn(openSearchContactBar);
        waitFor(searchContactInput);
        writeIn(searchContactInput, contactName);
    }


    public ProfileContactPage goToProfileContactView() {
        waitFor(contactListItem);
        tapOn(contactListItem);
        return new ProfileContactPage();
    }
}

package android.pages;

import android.utils.ContactsAndroidModel;
import org.openqa.selenium.By;

public class CreateContactPage extends BasePage {
    private final By saveButton = By.id("com.google.android.contacts:id/toolbar_button");
    private final By firstNameInput = By.xpath("//android.widget.EditText[@text='First name']");
    private final By lastNameInput = By.xpath("//android.widget.EditText[@text='Last name']");
    private final By companyInput = By.xpath("//android.widget.EditText[@text='Company']");
    private final By phoneInput = By.xpath("//android.widget.EditText[@text='Phone']");
    private final By emailInput = By.xpath("//android.widget.EditText[@text='Email']");

    public ContactHomePage saveNewContactInfo(ContactsAndroidModel contactInfo) {
        // ToDo verify if it possible to scroll if the element goes out of screen
        waitFor(saveButton);
        writeIn(firstNameInput, contactInfo.getFirstName());
        writeIn(lastNameInput, contactInfo.getLastName());
        writeIn(companyInput, contactInfo.getCompany());
        writeIn(emailInput, contactInfo.getEmail());
        writeIn(phoneInput, contactInfo.getPhone());
        tapOn(saveButton);
        return new ContactHomePage();
    }
}

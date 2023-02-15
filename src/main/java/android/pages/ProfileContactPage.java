package android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;

public class ProfileContactPage extends BasePage {
    private final By contactName = By.id("com.google.android.contacts:id/large_title");
    private final By contactInfo = By.id("com.google.android.contacts:id/header");


    public ArrayList<String> getStoredContactInfo() {
        ArrayList<String> storedContactInfo = new ArrayList<>();

        storedContactInfo.add(getDriver().findElement(contactName).getText());

        ArrayList<WebElement> contactMethods = (ArrayList<WebElement>) getDriver().findElements(contactInfo);

        for (WebElement method : contactMethods) {
            storedContactInfo.add(method.getText());
        }
        return storedContactInfo;

    }
}

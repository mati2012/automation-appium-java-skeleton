package android.pages;

import org.openqa.selenium.By;
import utils.DriverSetup;

public class BasePage extends DriverSetup {
    public void tapOn(By mobileElement) {
        getDriver().findElement(mobileElement).click();
    }

    public void writeIn(By mobileElement, String textToInput) {
        getDriver().findElement(mobileElement).sendKeys(textToInput);
    }
}

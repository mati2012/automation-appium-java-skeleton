package android.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import utils.DriverSetup;

import java.time.Duration;

public class BasePage extends DriverSetup {

    public void tapOn(By mobileElement) {
        getDriver().findElement(mobileElement).click();
    }

    public void writeIn(By mobileElement, String textToInput) {
        getDriver().findElement(mobileElement).sendKeys(textToInput);
    }

    public void waitFor(By mobileElement) {
        Wait wait = new FluentWait(getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .ignoring(TimeoutException.class);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileElement));
    }
}

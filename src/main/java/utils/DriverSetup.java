package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.cdimascio.dotenv.Dotenv;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class DriverSetup {
    private static final Dotenv dotEnv = Dotenv.load();
    private static AppiumDriverLocalService service;
    private static AppiumDriver driver;

    @BeforeClass
    public static void startServer() {
        //starts appium service
        service = new AppiumServiceBuilder()
                .usingAnyFreePort()
                .build();
        service.start();
    }


    @BeforeMethod
    public static void setupDriver() {
        //set up driver depeding on the platform set on .env before each test in order to be a clean run
        String platform = dotEnv.get("PLATFORM");
        if (platform == null) {
            throw new RuntimeException("Platform is not defined");
        }
        switch (platform.toUpperCase()) {
            case "IOS" -> driver = iosDriver();
            case "ANDROID" -> driver = androidDriver();
        }
    }

    @AfterMethod
    public static void closeApp() {
        if (driver != null) driver.quit();
    }

    @AfterClass
    public static void tearDown() {
        if (driver != null) driver.quit();
        if (service.isRunning()) service.stop();
    }

    private static AppiumDriver androidDriver() {

        // setting capabilities for android driver
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, dotEnv.get("PLATFORM_NAME"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, dotEnv.get("PLATFORM_VERSION"));
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, dotEnv.get("ANDROID_DRIVER"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, dotEnv.get("DEVICE_NAME"));
        capabilities.setCapability("appPackage", dotEnv.get("APP_PACKAGE"));
        capabilities.setCapability("appActivity", dotEnv.get("APP_ACTIVITY"));

//        ToDo: define an especific app
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, {PATH/TO/TESTAPP.APK});

        return new AndroidDriver(service.getUrl(), capabilities);
    }

    private static AppiumDriver iosDriver() {
        return null;
    }

    public static AppiumDriver getDriver() {
        return driver;
    }

}

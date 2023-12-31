package infrastructure;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static infrastructure.ConfigurationReader.*;

public class AppiumWrapper {
    private final AndroidDriver<MobileElement> driver;
    public AppiumWrapper() throws MalformedURLException {
        initializeConfig("config.json");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", getPlatformName());
        caps.setCapability("platformVersion", getPlatformVersion());
        caps.setCapability("deviceName", getDeviceName());
        caps.setCapability("appPackage", getAppPackage());
        caps.setCapability("appActivity", getAppActivity());
        caps.setCapability("automationName", getAutomationName());
        this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);
    }

    public AndroidDriver<MobileElement> getDriver() {
        if (driver != null){
            return this.driver;
        }
        else
            throw new NullPointerException("driver is null, call AppiumWrapper constructor first");
    }
}
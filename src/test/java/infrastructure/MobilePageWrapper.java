package infrastructure;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;

import static infrastructure.ConfigurationReader.*;

public class MobilePageWrapper {

    private BaseMobilePage currentPage;
    private AndroidDriver<MobileElement> driver;

    public MobilePageWrapper() {

        initializeConfig("config.json");
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", getPlatformName());
        caps.setCapability("platformVersion", getPlatformVersion());
        caps.setCapability("deviceName", getDeviceName());
        caps.setCapability("appPackage", getAppPackage());
        caps.setCapability("appActivity", getAppActivity());
        caps.setCapability("automationName", getAutomationName());
        try {
            this.driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/"), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends BaseMobilePage> T createPage(Class<T> pageType) {
        return createPage(pageType, null);
    }

    public <T extends BaseMobilePage> T createPage(Class<T> pageType, String url) {
        try {
            Constructor<T> constructor = pageType.getConstructor(AndroidDriver.class);
            if (url != null) {
                driver.get(url);
            }
            T page = constructor.newInstance(driver);
            currentPage = page;
            return page;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException("relevant constructor not found", e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public void close(){
        driver.close();
    }

    public void maximize() {
        driver.manage().window().maximize();
    }
    public <T extends BaseMobilePage> T getCurrentPage(){
        return (T)currentPage;
    }
}

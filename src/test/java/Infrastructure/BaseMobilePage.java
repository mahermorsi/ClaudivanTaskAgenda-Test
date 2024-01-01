package Infrastructure;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

public class BaseMobilePage {
    protected AndroidDriver<MobileElement> driver;

    public BaseMobilePage(AndroidDriver<MobileElement>driver) {
        this.driver = driver;
    }
    public void refreshPage(){
        driver.navigate().refresh();
    }
    public void maximize(){
        driver.manage().window().maximize();
    }
    public void fullScreen(){
        driver.manage().window().fullscreen();
    }
}

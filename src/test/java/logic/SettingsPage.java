package logic;

import infrastructure.BaseMobilePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SettingsPage extends BaseMobilePage {

    WebDriverWait wait;

    private final String FIRST_DAY_OF_THE_WEEK_BUTTON="//android.widget.TextView[@text=\"First day of the week\"]";
    private final String CHOSE_FIRST_DAY_OF_THE_WEEK="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Monday\"]";
    private final String BACK_BUTTON="//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    private final String HOME_PAGE_CLICK= "//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/tvTitulo\" and @text=\"Calendar\"]";
    public SettingsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        wait= new WebDriverWait(this.driver, 5);
    }

    public void clickOnFirstDayOfTheWeek() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(FIRST_DAY_OF_THE_WEEK_BUTTON)));
        MobileElement firstDayOfTheWeek = this.driver.findElement(MobileBy.xpath(FIRST_DAY_OF_THE_WEEK_BUTTON));
        firstDayOfTheWeek.click();
    }
    public void choseFirstDayOfTheWeek(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(CHOSE_FIRST_DAY_OF_THE_WEEK)));
        MobileElement choseFirstDay = driver.findElement(MobileBy.xpath(CHOSE_FIRST_DAY_OF_THE_WEEK));
        choseFirstDay.click();
    }
    public void clickBackButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(BACK_BUTTON)));
        MobileElement backButton = driver.findElement(MobileBy.xpath(BACK_BUTTON));
        backButton.click();

        slideTheMenu();
    }

    private void slideTheMenu() {


        Dimension size = driver.manage().window().getSize();
        int startX =(int) (size.width *0.8);
        int startY =size.height/2 ;
        int endx = (int) (size.width * 0.2);

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                .moveTo(PointOption.point(startX, endx))
                .release();
        touchAction.release();

    }
}

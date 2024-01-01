package logic;

import infrastructure.BaseMobilePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubMenuPage extends BaseMobilePage {

    WebDriverWait wait;
    // STATIC LOCATORS
    private final String ALL_EVENTS = "com.claudivan.taskagenda:id/btEventos";
    private final String LATE_EVENTS = "com.claudivan.taskagenda:id/btEventosAtrasados";
    private final String COLORS_AND_EVENT = "com.claudivan.taskagenda:id/btCores";
    private MobileElement allEventsElement;
    private MobileElement lateEventsElement;
    private MobileElement colorsAndEventElement;

    // DYNAMIC LOCATORS
    private final String CHECK_ALL_EVENTS = "//android.widget.TextView[@text=\"All events\"]";
    private final String CHECK_LATE_EVENTS = "//android.widget.TextView[@text=\"Late events\"]";



    public SubMenuPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        wait= new WebDriverWait(this.driver, 7);
        allEventsElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(ALL_EVENTS)));
        lateEventsElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(LATE_EVENTS)));
        colorsAndEventElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(COLORS_AND_EVENT)));
    }
    public void clickOnAllEvents(){
        allEventsElement.click();
    }
    public void clickOnLateEvents(){
        lateEventsElement.click();
    }
    public void clickOnColorsAndEvent(){
        colorsAndEventElement.click();
    }

    public boolean isNagivatedToAllEvents(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(CHECK_ALL_EVENTS))).getText().contains("All events");
    }
    public boolean isNagivatedToLatevents(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(CHECK_LATE_EVENTS))).getText().contains("Late events");
    }



}

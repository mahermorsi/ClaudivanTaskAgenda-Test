package logic;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventsPage extends WeekEvent{
    private static AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    private final String EVENT_BUTTON="//android.widget.ListView[@resource-id=\"com.claudivan.taskagenda:id/lvListaEventos\"]/android.widget.FrameLayout/android.widget.RelativeLayout";
    private final String DELETE_BUTTON="com.claudivan.taskagenda:id/item_excluir";
    private final String YES_DELETE_BUTTON= "android:id/button1";
    private final String BACK_BUTTON="//android.widget.ImageButton[@content-desc=\"Navigate up\"]";
    private final String NO_PENDING_EVENT="com.claudivan.taskagenda:id/btEventosSemana";
    public EventsPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        this.driver=driver;
        wait= new WebDriverWait(this.driver, 5);
    }

    public void clickOnEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(EVENT_BUTTON)));
        MobileElement eventButton = driver.findElement(MobileBy.xpath(EVENT_BUTTON));
        eventButton.click();
    }
    public void deleteEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(DELETE_BUTTON)));
        MobileElement deleteButton = driver.findElement(MobileBy.id(DELETE_BUTTON));
        deleteButton.click();
    }
    public void yesDeleteButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(YES_DELETE_BUTTON)));
        MobileElement yesDeleteBtn = driver.findElement(MobileBy.id(YES_DELETE_BUTTON));
        yesDeleteBtn.click();
    }

    public String checkDeleteEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(BACK_BUTTON)));
        MobileElement backButton = driver.findElement(MobileBy.xpath(BACK_BUTTON));
        backButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(NO_PENDING_EVENT)));
        MobileElement noPending = driver.findElement(MobileBy.id(NO_PENDING_EVENT));
        noPending.click();
        return noPending.getAttribute("text");

    }
}

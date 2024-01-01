package logic;

import infrastructure.BaseMobilePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeekEvent extends BaseMobilePage {
    WebDriverWait wait;

    private  final String PLUS_BUTTON="com.claudivan.taskagenda:id/btNovoEvento";
    private final String TODAY_BUTTON= "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Today\"]";
    private final String FILL_NAME= "com.claudivan.taskagenda:id/etTitulo";
    private final String FILL_NAME_TEXT= "//android.widget.EditText[@resource-id=\"com.claudivan.taskagenda:id/etTitulo\"]";
    private final String SAVE_BUTTON="com.claudivan.taskagenda:id/item_salvar";
    private final String PENDING_EVENT_BUTTON = "com.claudivan.taskagenda:id/btEventosSemana";
    private final String EVENT_NAME="com.claudivan.taskagenda:id/tvTitulo";
    private final String EVENTS_PENDING ="//android.widget.ListView[@resource-id=\"com.claudivan.taskagenda:id/lvListaEventos\"]/android.widget.FrameLayout[1]/android.widget.RelativeLayout";
    private final String TASK_AGENDA_ALLOW_BUTTON="com.android.permissioncontroller:id/permission_allow_button";
    private final String MENU_BUTTON="com.claudivan.taskagenda:id/hamburguer";
    private final String SITTINGS_BUTTON="com.claudivan.taskagenda:id/tvAjustes";
    private final String FIRST_DAY_OF_THE_WEEK= "//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/dia_semana\" and @text=\"Mon\"]";
    public WeekEvent(AndroidDriver<MobileElement> driver){
        super(driver);
        wait= new WebDriverWait(this.driver, 5);
    }
    public void clickOnPlusButton(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(PLUS_BUTTON)));
        MobileElement plusButton = driver.findElement(MobileBy.id(PLUS_BUTTON));
        plusButton.click();
    }

    public void clickOnTodayButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(TODAY_BUTTON)));
        MobileElement todayButton = driver.findElement(MobileBy.xpath(TODAY_BUTTON));
        todayButton.click();
    }

    public void fillEventName(String eventName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(FILL_NAME)));
        MobileElement fillNameClick = driver.findElement(MobileBy.id(FILL_NAME));
        fillNameClick.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(FILL_NAME_TEXT)));
        MobileElement fillNameText = driver.findElement(MobileBy.xpath(FILL_NAME_TEXT));
        fillNameText.sendKeys(eventName);
    }

    public void clickSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(SAVE_BUTTON)));
        MobileElement saveButton = driver.findElement(MobileBy.id(SAVE_BUTTON));
        saveButton.click();
    }

    public String checkPendingEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(PENDING_EVENT_BUTTON)));
        MobileElement pendingEventButton = driver.findElement(MobileBy.id(PENDING_EVENT_BUTTON));
        pendingEventButton.click();
        //allowTask();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(EVENTS_PENDING)));
        MobileElement eventButton = driver.findElement(MobileBy.xpath(EVENTS_PENDING));
        eventButton.click();

        MobileElement eventName = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(EVENT_NAME)));
        return eventName.getAttribute("text");
    }

    private void allowTask() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(TASK_AGENDA_ALLOW_BUTTON)));
        MobileElement allowTask = driver.findElement(MobileBy.id(TASK_AGENDA_ALLOW_BUTTON));
        allowTask.click();

    }

    public void clickOnMenu() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(MENU_BUTTON)));
        MobileElement menuButton = driver.findElement(MobileBy.id(MENU_BUTTON));
        menuButton.click();
    }

    public void clickOnSittingsButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(SITTINGS_BUTTON)));
        MobileElement sittingsButton = driver.findElement(MobileBy.id(SITTINGS_BUTTON));
        sittingsButton.click();
    }

    public String checkFirstDayOfTheWeek() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(FIRST_DAY_OF_THE_WEEK)));
        MobileElement firstDayOfTheWeek = driver.findElement(MobileBy.xpath(FIRST_DAY_OF_THE_WEEK));
        firstDayOfTheWeek.click();
        return firstDayOfTheWeek.getAttribute("text");
    }
}

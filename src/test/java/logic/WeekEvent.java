package logic;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WeekEvent{
    private static AndroidDriver<MobileElement> driver;
    WebDriverWait wait;
    public WeekEvent(AndroidDriver<MobileElement> driver){
        this.driver=driver;
        wait= new WebDriverWait(this.driver, 5);
    }
    private  final String PLUS_BUTTON="com.claudivan.taskagenda:id/btNovoEvento";
    private final String TODAY_BUTTON= "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Today\"]";
    private final String FILL_NAME= "com.claudivan.taskagenda:id/etTitulo";
    private final String FILL_NAME_TEXT= "//android.widget.EditText[@resource-id=\"com.claudivan.taskagenda:id/etTitulo\"]";
    private final String SAVE_BUTTON="com.claudivan.taskagenda:id/item_salvar";
    private final String PENDINING_EVENT_BUTTON= "com.claudivan.taskagenda:id/btEventosSemana";
    private final String EVENT_NAME="com.claudivan.taskagenda:id/tvTitulo";
    private final String EVENTS_PENDINING="//android.widget.ListView[@resource-id=\"com.claudivan.taskagenda:id/lvListaEventos\"]/android.widget.FrameLayout[1]/android.widget.RelativeLayout";
    private final String TASK_AGENDA_ALLOW_BUTTON="com.android.permissioncontroller:id/permission_allow_button";
    private final String MENU_BUTTON="com.claudivan.taskagenda:id/hamburguer";
    private final String SITTINGS_BUTTON="com.claudivan.taskagenda:id/tvAjustes";
    private final String FIRST_DAY_OF_THE_WEEK= "//android.widget.TextView[@resource-id=\"com.claudivan.taskagenda:id/dia_semana\" and @text=\"Mon\"]";
    private final String ALL_EVENTS_BUTTON="com.claudivan.taskagenda:id/btEventos";
    private final String ADD_EVENT_AT_FOUR_O_CLOCK ="//android.widget.LinearLayout[@resource-id=\"com.claudivan.taskagenda:id/containerColunasHorarios\"]/android.widget.RelativeLayout[3]";
    private final String NEW_EVENT_BUTTON="//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"New event\"]";
    private final String FOUR_EVENT_DETAILS ="com.claudivan.taskagenda:id/tvTitulo";
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

    public void ckickSaveButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(SAVE_BUTTON)));
        MobileElement saveButton = driver.findElement(MobileBy.id(SAVE_BUTTON));
        saveButton.click();
    }

    public String checkPendiningEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(PENDINING_EVENT_BUTTON)));
        MobileElement pendinigEventButton = driver.findElement(MobileBy.id(PENDINING_EVENT_BUTTON));
        pendinigEventButton.click();
        allowTask();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(EVENTS_PENDINING)));
        MobileElement eventButton = driver.findElement(MobileBy.xpath(EVENTS_PENDINING));
        eventButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(EVENT_NAME)));
        MobileElement eventName = driver.findElement(MobileBy.id(EVENT_NAME));
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

    public void clickAllEvents() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(ALL_EVENTS_BUTTON)));
        MobileElement allEventsButton = driver.findElement(MobileBy.id(ALL_EVENTS_BUTTON));
        allEventsButton.click();
    }

    public void clickon4Pmtoaddevent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(ADD_EVENT_AT_FOUR_O_CLOCK)));
        MobileElement addEventAt4Oclock = driver.findElement(MobileBy.xpath(ADD_EVENT_AT_FOUR_O_CLOCK));
        addEventAt4Oclock.click();
    }

    public void clickOnNewEvent() {
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath(NEW_EVENT_BUTTON)));
        MobileElement newEventButton = driver.findElement(MobileBy.xpath(NEW_EVENT_BUTTON));
        newEventButton.click();
    }
    public String checkAddingNewEventAt3oClock(){
        allowTask();
        clickon4Pmtoaddevent();
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.id(FOUR_EVENT_DETAILS)));
        MobileElement fourEventDetails = driver.findElement(MobileBy.id(FOUR_EVENT_DETAILS));
        fourEventDetails.click();
        return fourEventDetails.getAttribute("text");

    }
}

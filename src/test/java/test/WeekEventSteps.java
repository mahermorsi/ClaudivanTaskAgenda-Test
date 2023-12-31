package test;

import Infrastructure.AppiumWrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.EventsPage;
import logic.Sittings;
import logic.WeekEvent;
import org.junit.Assert;
import utils.TestContext;

import java.net.MalformedURLException;

public class WeekEventSteps {

    private WeekEvent weekEvent;
    private static AndroidDriver<MobileElement> driver;
    private final TestContext context;
    private Sittings sittings;
    private EventsPage events;

    public WeekEventSteps(TestContext context) throws MalformedURLException {
        this.context = context;
    }

    @Given("i am on week page")
    public void iAmOnWeekPage() throws MalformedURLException {
        AppiumWrapper appiumWrapper = new AppiumWrapper();
        driver= appiumWrapper.getDriver();
        context.put("driver",driver);
        weekEvent=new WeekEvent(context.get("driver"));
    }

    @When("i click on plus icon")
    public void iClickOnPlusIcon() {
        weekEvent.clickOnPlusButton();
    }

    @And("i click on today button")
    public void iClickOnTodayButton() {
        weekEvent.clickOnTodayButton();
    }

    @And("i fill a event {string}")
    public void iFillEventaName(String eventName) {
        weekEvent.fillEventName(eventName);
    }

    @And("i click save")
    public void iClickSave() {
        weekEvent.ckickSaveButton();
    }

    @Then("validate the event {string} is added")
    public void validateTheEventIsAdded(String eventName) {
        Assert.assertEquals(weekEvent.checkPendiningEvent(),eventName);
    }


    @When("i click on menu")
    public void iClickOnMenu() {
        weekEvent.clickOnMenu();
    }

    @And("i click on settings button")
    public void iClickOnSettingsButton() {
        weekEvent.clickOnSittingsButton();
    }

    @And("i click on first day of the week")
    public void iClickOnFirstDayOfTheWeek() {
        sittings=new Sittings(context.get("driver"));
        sittings.clickOnFirstDayOfTheWeek();
    }

    @And("i chose monday to be the first day of the week")
    public void iChoseMondayToBeTheFirstDayOfTheWeek() {
        sittings.choseFirstDayOfTheWeek();
    }

    @And("click on back button")
    public void clickOnBackButton() {
        sittings.clickBackButton();
    }

    @Then("verify that monday is the first day of the week")
    public void verifyThatMondayIsTheFirstDayOfTheWeek() {
        Assert.assertEquals(weekEvent.checkFirstDayOfTheWeek(),"Mon");
    }

    @And("i click on all events")
    public void iClickOnAllEvents() {
        weekEvent.clickAllEvents();
    }

    @And("i click on the event")
    public void iClickOnTheEvent() {
        events=new EventsPage(context.get("driver"));
        events.clickOnEvent();
    }

    @And("click the delete button")
    public void clickTheDeleteButton() {
        events.deleteEvent();
    }

    @And("click yes to delete that event")
    public void clickYesToDeleteThatEvent() {
        events.yesDeleteButton();
    }

    @Then("verify the event is deleted")
    public void verifyTheEventIsDeleted() {
        Assert.assertEquals(events.checkDeleteEvent(),"NO PENDING EVENT");
    }

    @When("i click on four pm")
    public void iClickOnPm() {
        weekEvent.clickon4Pmtoaddevent();
    }

    @And("click new event")
    public void clickNewEvent() {
        weekEvent.clickOnNewEvent();
    }

//    @And("fill a event {string}")
//    public void fillAEventString() {
//    }

//    @And("click save")
//    public void clickSave() {
//    }

    @Then("the {string} event will be added")
    public void theEventWillBeAdded(String eventName) {
        Assert.assertEquals(weekEvent.checkAddingNewEventAt3oClock(),eventName);
    }
}

package test;
import infrastructure.TestContext;
import infrastructure.AppiumWrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.Settings;
import logic.WeekEvent;
import org.junit.Assert;

import java.net.MalformedURLException;

public class WeekEventSteps {

    private WeekEvent weekEvent;
    public TestContext context;
    private Settings sittings;

    public WeekEventSteps(TestContext context){
        this.context = context;
    }

    @Given("i am on week page")
    public void iAmOnWeekPage() {
        weekEvent=new WeekEvent(context.get("driver"));
        context.put("weekEvent", weekEvent);
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
        weekEvent.clickSaveButton();
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
        sittings=new Settings(context.get("driver"));
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
}

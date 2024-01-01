package test;
import infrastructure.MobilePageWrapper;
import infrastructure.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.SettingsPage;
import logic.WeekEventPage;
import org.junit.Assert;


public class WeekEventSteps {

    private WeekEventPage weekEvent;
    public TestContext context;
    private SettingsPage settings;

    public WeekEventSteps(TestContext context){
        this.context = context;
    }

    @Given("i am on week page")
    public void iAmOnWeekPage() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        weekEvent = mobileWrapper.createPage(WeekEventPage.class);
    }

    @When("I click on plus icon")
    public void iClickOnPlusIcon() {
        weekEvent.clickOnPlusButton();
    }

    @And("I click on today button")
    public void iClickOnTodayButton() {
        weekEvent.clickOnTodayButton();
    }

    @And("I fill in event Name {string}")
    public void iFillEventaName(String eventName) {
        weekEvent.fillEventName(eventName);
    }

    @And("I click save")
    public void iClickSave() {
        weekEvent.clickSaveButton();
    }

    @Then("validate the event {string} is added")
    public void validateTheEventIsAdded(String eventName) {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        weekEvent = mobileWrapper.getCurrentPage();
        Assert.assertEquals(weekEvent.checkPendingEvent(),eventName);
    }


    @When("I click on menu")
    public void iClickOnMenu() {
        weekEvent.clickOnMenu();
    }

    @And("I click on settings button")
    public void iClickOnSettingsButton() {
        weekEvent.clickOnSittingsButton();
    }

    @And("I click on first day of the week")
    public void iClickOnFirstDayOfTheWeek() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        settings = mobileWrapper.createPage(SettingsPage.class);
        settings.clickOnFirstDayOfTheWeek();
    }

    @And("I chose monday to be the first day of the week")
    public void iChoseMondayToBeTheFirstDayOfTheWeek() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        settings = mobileWrapper.getCurrentPage();
        settings.choseFirstDayOfTheWeek();
    }

    @And("click on back button")
    public void clickOnBackButton() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        settings = mobileWrapper.getCurrentPage();
        settings.clickBackButton();
    }

    @Then("verify that monday is the first day of the week")
    public void verifyThatMondayIsTheFirstDayOfTheWeek() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        weekEvent = mobileWrapper.createPage(WeekEventPage.class);

        Assert.assertEquals(weekEvent.checkFirstDayOfTheWeek(),"Mon");
    }
}

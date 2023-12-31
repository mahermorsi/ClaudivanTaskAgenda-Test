import Infrastructure.AppiumWrapper;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.net.MalformedURLException;

public class WeekEventSteps {

    private static AppiumWrapper appiumWrapper;
    private static AndroidDriver<MobileElement> driver;

    @Given("i am on week page")
    public void iAmOnWeekPage() throws MalformedURLException {
        appiumWrapper=new AppiumWrapper();
        driver= appiumWrapper.getDriver();
    }

    @When("i click on plus icon")
    public void iClickOnPlusIcon() {
    }

    @And("i click on today button")
    public void iClickOnTodayButton() {
    }

    @And("i fill event name")
    public void iFillEventName() {
    }

    @And("i click save")
    public void iClickSave() {
    }

    @Then("validate the event is added")
    public void validateTheEventIsAdded() {
    }

    @When("i ckick on {int} Thu , {int}:{int} rectangle")
    public void iCkickOnThuRectangle(int arg0, int arg1, int arg2) {
    }

    @And("i click new event")
    public void iClickNewEvent() {
    }

    @And("i fill event {string}")
    public void iFillEventName() {
    }

    @Then("event {string} should be displayed and the same rectangle")
    public void eventNameShouldBeDisplayedAndTheSameRectangle() {
    }
}

package test;

import infrastructure.MobilePageWrapper;
import infrastructure.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import logic.ColorsAndEventTypesPage;
import logic.SubMenuPage;
import logic.WeekEventPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SubMenuTest {
    public TestContext context;
    private SubMenuPage subMenuPage;
    private ColorsAndEventTypesPage colorsAndEventTypesPage;

    public SubMenuTest(TestContext context){
        this.context=context;
    }

    @And("I click on top left menu icon")
    public void iClickOnTopLeftMenuIcon() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        WeekEventPage weekEvent = mobileWrapper.getCurrentPage();
        weekEvent.clickOnMenu();
    }

    @When("I click on Late events")
    public void iClickOnLateEvents() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        subMenuPage = mobileWrapper.createPage(SubMenuPage.class);
        subMenuPage.clickOnLateEvents();
    }

    @Then("I should be navigated to late events page")
    public void iShouldBeNavigatedToLateEventsPage() {
        assertTrue(subMenuPage.isNagivatedToLatevents());
    }

    @When("I click on Colors and event types")
    public void iClickOnColorsAndEeventTypes() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        subMenuPage = mobileWrapper.createPage(SubMenuPage.class);
        subMenuPage.clickOnColorsAndEvent();
    }

    @And("I click on Dark mode")
    public void iClickOnDarkMode() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        colorsAndEventTypesPage = mobileWrapper.createPage(ColorsAndEventTypesPage.class);
        colorsAndEventTypesPage.clickOnDarkMode();
    }

    @And("I click on Disabled button")
    public void iClickOnDisabledButton() {
        colorsAndEventTypesPage.chooseDarkModeEnabledState();
    }

    @Then("Dark mode should be disabled")
    public void darkModeShouldBeDisabled() {
        assertTrue(colorsAndEventTypesPage.isDarkModeEnabled());
    }

    @When("I click on All events")
    public void iClickOnAllEvents() {
        MobilePageWrapper mobileWrapper = context.get("MobileWrapper");
        subMenuPage = mobileWrapper.createPage(SubMenuPage.class);
        subMenuPage.clickOnAllEvents();
    }

    @Then("I should be navigated to All events page")
    public void iShouldBeNavigatedToAllEventsPage() {
        assertTrue(subMenuPage.isNagivatedToAllEvents());
    }
}

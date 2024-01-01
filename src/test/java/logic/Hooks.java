package logic;

import infrastructure.AppiumWrapper;
import infrastructure.ConfigurationReader;
import infrastructure.TestContext;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.io.IOException;
import java.net.MalformedURLException;


public class Hooks {
    public TestContext context;

    public Hooks(TestContext context) {
        this.context=context;
    }
    @Before
    public void setUp() throws MalformedURLException {
        System.out.println("Starting a Scenario");
        ConfigurationReader.initializeConfig("config.json");
        AppiumWrapper appiumWrapper = new AppiumWrapper();
        AndroidDriver<MobileElement> driver = appiumWrapper.getDriver();
        context.put("driver", driver);
    }
    @After
    public void tearDown() throws IOException, InterruptedException {
        System.out.println("Scenario ENDED, cleaning environment and closing driver");
        AndroidDriver<MobileElement> driver =context.get("driver");
        //driver.close();


    }
}



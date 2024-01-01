package logic;


import infrastructure.MobilePageWrapper;
import infrastructure.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks {
    public TestContext context;

    public Hooks(TestContext context) {
        this.context=context;
    }
    @Before
    public void setUp() {
        System.out.println("Starting a Scenario");
        MobilePageWrapper mobileWrapper = new MobilePageWrapper();
        context.put("MobileWrapper", mobileWrapper);
    }
    @After
    public void tearDown()  {
        System.out.println("Scenario ENDED, cleaning environment and closing driver");
        MobilePageWrapper pageWrapper = context.get("MobileWrapper");
        //pageWrapper.close();


    }
}



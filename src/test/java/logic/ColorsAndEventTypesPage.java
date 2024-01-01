package logic;

import Infrastructure.BaseMobilePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ColorsAndEventTypesPage extends BaseMobilePage {
    WebDriverWait wait;
    // STATIC LOCATORS
    private final String DARK_MODE_POPUP = "com.claudivan.taskagenda:id/itemTemaEscuro";
    private final String DARK_MODE_STATE = "com.claudivan.taskagenda:id/tvTemaEscuroValor";
    // DYNAMIC LOCATORS
    private final String DISABLED_SELECTION = "//android.widget.TextView[@resource-id=\"android:id/text1\" and @text=\"Disabled\"]";
    private MobileElement darkModeButtonElement;
    private MobileElement darkModeStateElement;
    public ColorsAndEventTypesPage(AndroidDriver<MobileElement> driver) {
        super(driver);
        wait= new WebDriverWait(this.driver, 7);
        darkModeButtonElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(DARK_MODE_POPUP)));
        //darkModeStateElement = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(DARK_MODE_STATE)));
    }
    public void clickOnDarkMode(){
        darkModeButtonElement.click();
    }
    public void chooseDarkModeEnabledState(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath(DISABLED_SELECTION))).click();
    }
    public boolean isDarkModeEnabled(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.id(DARK_MODE_STATE))).getText().contains("Disabled");
    }
}

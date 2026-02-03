package com.demoqa.pages.alertsFrameWindows;

import com.demoqa.core.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.awt.SystemColor.text;

public class AlertsPage extends BasePage {
    public AlertsPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(id = "timerAlertButton")
    WebElement timerAlertButton;

    public AlertsPage verifyAlertWithTimer() {
        clickWithJS(timerAlertButton, 0, 200);
        Assertions.assertTrue(isAlertPresent(5));
        return this;

    }

    @FindBy(id = "confirmButton")
    WebElement confirmButton;

    public AlertsPage clickOnResult(String result) {
        clickWithJS(confirmButton,0,200);
        if (result!=null && result.equals("Ok")) {
            driver.switchTo().alert().accept();
        }
        else if (result != null && result.equals("Cancel")) {
            driver.switchTo().alert().dismiss();
        }
        return this;
    }
    @FindBy(id="confirmResult")
    WebElement confirmResult;
    
    public AlertsPage verifyResult(String) {
        Assertions.assertTrue(isContainsText(text, confirmResult));
        return this;
    }

    public boolean isContainsText(String text) {
        return confirmResult.getText().contains(text);

    }

    @FindBy(id = "promtButton")
    WebElement promtButton;

    public AlertsPage clickOnPromptButton() {
        clickWithJS(promButton, 0, 300);
        return this;
    }
    public AlertsPage sendMessageToAlert(String message) {
        if (message!=null) {
            driver.switchTo().alert().sendKeys();
            driver.switchTo().alert().accept();
        }
        return this;
    }
}


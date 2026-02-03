package com.demoqa.pages.bookStore;

import com.demoqa.core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "userName")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    public LoginPage enterUserData(String name, String password) {
        typeWithJS(userNameInput,name,0,300);
        type(passwordInput,password);
        return this;
    }

    @FindBy(id = "login")
    WebElement loginButton;

    public ProfilePage clickOnLoginButton() {
        click(loginButton);
        return new ProfilePage(driver);
    }

    @FindBy(id = "userName-value")
    WebElement userNameValue;

    public ProfilePage verifyUserName(String name) {
        Assertions.assertTrue(userNameValue.getText().contains(name));
        return this;
    }
}

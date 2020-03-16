package com.edureka.project.ObjectRepo;

import com.edureka.project.genericLib.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(name = "login")
    @CacheLookup
    private WebElement usernameEdit;

    @FindBy(name = "password")
    @CacheLookup
    private WebElement passwordEdit;

    @FindBy(name = "click")
    @CacheLookup
    private WebElement loginClk;

    @FindBy(name = "hello")
    @CacheLookup
    private WebElement failedMSG;
    public WebElement getUsernameEdit() {
        return usernameEdit;
    }

    public WebElement getPasswordEdit() {
        return passwordEdit;
    }

    public WebElement getLoginClk() {
        return loginClk;
    }

    public void login() throws Throwable {
        FileLib flib = new FileLib();
        String URL = flib.getCommonData("url");
        String USER = flib.getCommonData("user");
        String PASSWORD = flib.getCommonData("password");

        BaseClass.driver.manage().window().maximize();
        BaseClass.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        BaseClass.driver.get(URL);
        usernameEdit.sendKeys(USER);
        passwordEdit.sendKeys(PASSWORD);
        loginClk.click();
    }

    public WebElement getFailedMSG() {
        return failedMSG;
    }

}

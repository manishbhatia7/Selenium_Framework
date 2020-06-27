package com.mercurytravels.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignOnPage {
    WebDriver localDriver;
    public SignOnPage(WebDriver remoteWebdriver)
    {
        localDriver=remoteWebdriver;
        PageFactory.initElements(remoteWebdriver,this);
    }

    @FindBy(name="userName")
    @CacheLookup
    private WebElement txtuserName1;

    @FindBy(name="password")
    @CacheLookup
    private WebElement txtPassword1;

    @FindBy(name="login")
    @CacheLookup
    private WebElement btnSubmit;

    @FindBy(xpath="//img[contains(@src,'signon')]")
    @CacheLookup
    private WebElement imgSignon;



    public void setuserName(String uname)
    {
        txtuserName1.sendKeys(uname);
    }
    public void setpassWord(String pass)
    {
        txtPassword1.sendKeys(pass);
    }

    public FlightFinder enter_User_Credentials()
    {
        btnSubmit.click();
        return new FlightFinder(localDriver);
    }

    public void assert_Signon_Logo()
    {
        Assert.assertTrue(imgSignon.isDisplayed());
    }



}


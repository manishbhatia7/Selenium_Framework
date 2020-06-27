package com.mercurytravels.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Registration {
    WebDriver localDriver;
    private WebDriverWait wait;
    public Registration(WebDriver remoteWebdriver)
    {
        localDriver=remoteWebdriver;
        wait = new WebDriverWait(localDriver, 15, 50);
        PageFactory.initElements(remoteWebdriver,this);
    }
    @FindBy(name="firstName")
    @CacheLookup
    private WebElement txtfirstName;

    @FindBy(name="lastName")
    @CacheLookup
    private WebElement txtlastName;

    @FindBy(name="phone")
    @CacheLookup
    private WebElement txtPhone;

    @FindBy(name="userName")
    @CacheLookup
    private WebElement txtEmail;

    @FindBy(name="address1")
    @CacheLookup
    private WebElement txtAddress1;

    @FindBy(name="city")
    @CacheLookup
    private WebElement txtCity;

    @FindBy(name="state")
    @CacheLookup
    private WebElement txtState;

    @FindBy(name="postalCode")
    @CacheLookup
    private WebElement txtpostalCode;

    @FindBy(name="country")
    @CacheLookup
    private WebElement ddCountry;

    @FindBy(name="email")
    @CacheLookup
    private WebElement txtuserName;

    @FindBy(name="password")
    @CacheLookup
    private WebElement txtPassword;

    @FindBy(name="confirmPassword")
    @CacheLookup
    private WebElement txtconfirmPassword;

    @FindBy(name="register")
    @CacheLookup
    private WebElement btnSubmit;

    @FindBy(xpath ="//font[contains(text(),'Thank you for registering.')]")
    @CacheLookup
    private WebElement lbl_Confirmation_Text;

    @FindBy(xpath =" //*[contains(text(),'Your user name is')]")
    @CacheLookup
    private WebElement lbl_User_Confirmation;

    @FindBy(linkText="sign-in")
    @CacheLookup
    private WebElement lnk_Sign_in;



    public void setfirstName(String fname)
{
    txtfirstName.sendKeys(fname);
}
    public void setlastName(String lname)
    {
        txtlastName.sendKeys(lname);
    }

    public void setPhone(String phone)
    {
        txtPhone.sendKeys(phone);
    }

    public void setEmail(String email)
    {
        txtEmail.sendKeys(email);
    }
    public void setAddress(String address)
    {
        txtAddress1.sendKeys(address);
    }

    public void setCity(String city)
    {
        txtCity.sendKeys(city);
    }

    public void setState(String state)
    {
        txtState.sendKeys(state);
    }

    public void setPincode(String pincode)
    {
        txtpostalCode.sendKeys(pincode);
    }

    public void selectCountry(String country)
    {
        Select ctry=new Select(ddCountry);
        ctry.selectByVisibleText(country);

    }

    public void setUserName(String username)
    {
        txtuserName.sendKeys(username);
    }

    public void setPassword(String password)
    {
        txtPassword.sendKeys(password);
    }

    public void setConfirmedPassword(String cpassword)
    {
        txtconfirmPassword.sendKeys(cpassword);
    }

    public void submit_Registration_details()
    {
        btnSubmit.click();
    }

    public void assertion_for_Registration()
    {

        Assert.assertTrue(lbl_Confirmation_Text.isDisplayed());
        Assert.assertTrue(lbl_User_Confirmation.isDisplayed());
    }

    public SignOnPage click_On_Sign_in()
    {
        wait.until(ExpectedConditions.visibilityOf(lnk_Sign_in));
        lnk_Sign_in.click();
        return new SignOnPage(localDriver);
    }















}


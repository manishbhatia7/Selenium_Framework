package com.mercurytravels.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PurchaseBookingTicket {
    WebDriver localDriver;

    public PurchaseBookingTicket(WebDriver remoteDriver)
    {
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    @FindBy(xpath ="//*[contains(text(),'Unified Airlines 363')]")
    @CacheLookup
    private WebElement lblOutFlight;

    @FindBy(xpath ="//*[contains(text(),'Pangea Airlines 632')]")
    @CacheLookup
    private WebElement lblInFlight;

    @FindBy(xpath ="//*[contains(text(),'609')]")
    @CacheLookup
    private WebElement lblPrice;

    @FindBy(name="passFirst0")
    @CacheLookup
    private WebElement txtFirstName;

    @FindBy(name="passLast0")
    @CacheLookup
    private WebElement txtLastName;

    @FindBy(name="pass.0.meal")
    @CacheLookup
    private WebElement ddSelectMeal;

    @FindBy(name="creditCard")
    @CacheLookup
    private WebElement ddSelectCCType;

    @FindBy(name="creditnumber")
    @CacheLookup
    private WebElement txtCCNo;

    @FindBy(name="billAddress1")
    @CacheLookup
    private WebElement txtBillAddress;

    @FindBy(name="billCity")
    @CacheLookup
    private WebElement txtBillCity;

    @FindBy(name="billState")
    @CacheLookup
    private WebElement txtBillState;

    @FindBy(name="billZip")
    @CacheLookup
    private WebElement txtBillZip;

    @FindBy(name="billCountry")
    @CacheLookup
    private WebElement ddSelectBillCountry;

    @FindBy(name="delAddress1")
    @CacheLookup
    private WebElement txtDelAddress;

    @FindBy(name="delCity")
    @CacheLookup
    private WebElement txtDelCity;

    @FindBy(name="delState")
    @CacheLookup
    private WebElement txtDelState;

    @FindBy(name="delZip")
    @CacheLookup
    private WebElement txtDelZip;

    @FindBy(name="delCountry")
    @CacheLookup
    private WebElement ddSelectDelCountry;

    @FindBy(name="buyFlights")
    @CacheLookup
    private WebElement btnPurchase;

    public void assert_out_Flight()
    {
        Assert.assertTrue(lblOutFlight.isDisplayed());
    }

    public void assert_in_Flight()
    {
        Assert.assertTrue(lblInFlight.isDisplayed());
    }

    public void assert_Price()
    {
        Assert.assertTrue(lblPrice.isDisplayed());
    }

    public void setFirstName(String fname)
    {
        txtFirstName.sendKeys(fname);
    }

    public void setLastName(String lname)
    {
        txtLastName.sendKeys(lname);
    }

    public void selectMeal(String meal)
    {
        Select meal1=new Select(ddSelectMeal);
        meal1.selectByVisibleText(meal);

    }

    public void selectCreditCardType(String type)
    {
        Select type1=new Select(ddSelectCCType);
        type1.selectByVisibleText(type);
    }

    public void setCreditCardNo(String no)
    {
        txtCCNo.sendKeys(no);
    }

    public void setBillingAddress(String address)
    {

        txtBillAddress.clear();
        txtBillAddress.sendKeys(address);
    }

    public void setBillingCity(String city)
    {
        txtBillCity.clear();
        txtBillCity.sendKeys(city);
    }

    public void setBillingState(String state)
    {
        txtBillState.clear();
        txtBillState.sendKeys(state);

    }
    public void setBillPincode(String code)
    {
        txtBillZip.clear();
        txtBillZip.sendKeys(code);
    }

    public void selectBillCountry(String country)
    {
        Select country1=new Select(ddSelectBillCountry);
        country1.selectByVisibleText(country);
    }

    public void setDeliveryAddress(String address)
    {
        txtDelAddress.clear();
        txtDelAddress.sendKeys(address);
    }

    public void setDeliveryCity(String city)
    {
        txtDelCity.clear();
        txtDelCity.sendKeys(city);
    }

    public void setDeliveryState(String state)
    {
        txtDelState.clear();
        txtDelState.sendKeys(state);
    }

    public void setDelPincode(String code)
    {
        txtDelZip.clear();
        txtDelZip.sendKeys(code);
    }

    public void selectDeliveryCountry(String country)
    {
        Select country1=new Select(ddSelectDelCountry);
        country1.selectByVisibleText(country);
    }

    public BookingReview click_On_SecurePurchase()
    {
        btnPurchase.click();
        return new BookingReview(localDriver);
    }

    public void handle_Alert()
    {
        localDriver.switchTo().alert().accept();
    }








































}

package com.mercurytravels.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BookingReview {
    WebDriver localDriver;
        public BookingReview(WebDriver remoteWebdriver)
        {
            localDriver=remoteWebdriver;
            PageFactory.initElements(remoteWebdriver,this);
        }
    @FindBy(xpath="//*[contains(text(),'itinerary has been booked!')]")
    @CacheLookup
    private WebElement lblBookingConfirmation;

    @FindBy(xpath="//*[contains(text(),'Frankfurt to London')]")
    @CacheLookup
    private WebElement lblFromCity;

    @FindBy(xpath="//*[contains(text(),'London to Frankfurt')]")
    @CacheLookup
    private WebElement lblToCity;

    @FindBy(xpath="//*[contains(text(),'1 passenger')]")
    @CacheLookup
    private WebElement lblNoofPassenger;

    @FindBy(xpath="//*[contains(text(),'Sea View Apartment')]")
    @CacheLookup
    private WebElement lblAddress;

    @FindBy(xpath="//*[contains(text(),'$609')]")
    @CacheLookup
    private WebElement lblPrice;

    @FindBy(xpath="//a[contains(@href,'mercury')]/img[contains(@src,'Logout')]")
    @CacheLookup
    private WebElement imgLogout;



    public void assert_Booking_Form()
    {
        Assert.assertEquals(lblBookingConfirmation.getText(),"Your itinerary has been booked!");
        Assert.assertEquals(lblFromCity.getText(),"Frankfurt to London");
        Assert.assertEquals(lblToCity.getText(),"London to Paris");
        Assert.assertEquals(lblNoofPassenger.getText(),"1");
        Assert.assertEquals(lblAddress.getText(),"Sea View Apartment");
        Assert.assertEquals(lblPrice.getText(),"$609");




    }

    public void click_On_Logout()
    {
        imgLogout.click();
    }









}

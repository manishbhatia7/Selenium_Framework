package com.mercurytravels.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class SelectFlight {
    WebDriver localDriver;
    public SelectFlight(WebDriver remoteDriver)
    {
        localDriver=remoteDriver;
        PageFactory.initElements(remoteDriver,this);
    }
    @FindBy(xpath = " //*[contains(text(),'Frankfurt to London')]")
    @CacheLookup
    private WebElement fromLabel;

    @FindBy(xpath = " //*[contains(text(),'London to Frankfurt')]")
    @CacheLookup
    private WebElement lblTo;

    @FindAll(@FindBy(name="outFlight"))
    @CacheLookup
    private List<WebElement> rdOutFlight;

    @FindAll(@FindBy(name="inFlight"))
    @CacheLookup
    private List<WebElement> rdinFlight;

    @FindBy(name="reserveFlights")
    @CacheLookup
    private WebElement btn_Reserve_Flights;

    public void assert_Outgoing()
    {
        Assert.assertTrue(fromLabel.isDisplayed());
    }

    public void assert_Incoming()
    {
        Assert.assertTrue(lblTo.isDisplayed());
    }

    public void select_Outgoing_Flight(String outgoing)
    {
        int size=rdOutFlight.size();
        for(int i=0;i<size;i++)
        {
            String svalue=rdOutFlight.get(i).getAttribute("value");
            if(svalue.contains(outgoing))
            {
                rdOutFlight.get(i).click();
                break;
            }

        }
    }
    public void select_Incoming_Flight(String incoming)
    {
        int size=rdinFlight.size();
        for(int i=0;i<size;i++)
        {
            String svalue=rdinFlight.get(i).getAttribute("value");
            if(svalue.contains(incoming))
            {
                rdinFlight.get(i).click();
                break;
            }

        }
    }

    public PurchaseBookingTicket click_On_Continue()
    {
        btn_Reserve_Flights.click();
        return new PurchaseBookingTicket(localDriver);
    }


    


}

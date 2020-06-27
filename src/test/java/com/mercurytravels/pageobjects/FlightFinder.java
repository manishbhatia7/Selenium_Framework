package com.mercurytravels.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class FlightFinder {
    WebDriver localDriver;

    public FlightFinder(WebDriver remoteWebdriver)
    {
        localDriver=remoteWebdriver;
        PageFactory.initElements(remoteWebdriver,this);
    }

    @FindAll(@FindBy (name="tripType"))
    @CacheLookup
    private List<WebElement> rdTripType;

    @FindBy(name="fromPort")
    @CacheLookup
    private WebElement ddFromCity;

    @FindBy(name="fromDay")
    @CacheLookup
    private WebElement ddDepartDate;

    @FindBy(name="toPort")
    @CacheLookup
    private WebElement ddToCity;

    @FindBy(name="toDay")
    @CacheLookup
    private WebElement ddArrivalDate;

    @FindBy(name="findFlights")
    @CacheLookup
    private WebElement btnContinue;

    public void selectTripType(String rtype) {
        int size = rdTripType.size();
        for (int i = 0; i < size; i++) {
            String sValue = rdTripType.get(i).getAttribute("value");
            if (sValue.equalsIgnoreCase(rtype)) {
                rdTripType.get(i).click();
                break;

            }

        }
    }

        public void selectToCity(String fcity)
        {
            Select to =new Select(ddFromCity);
            to.selectByVisibleText(fcity);

        }

        public void selectDepartDate(String ddate)
        {
            Select to =new Select(ddDepartDate);
            to.selectByVisibleText(ddate);
        }

        public void selectFromCity(String tcity)
        {
            Select to =new Select(ddToCity);
            to.selectByVisibleText(tcity);

        }

        public void selectArrivalDate(String adate)
        {
        Select from =new Select(ddArrivalDate);
        from.selectByVisibleText(adate);
        }


        public SelectFlight click_On_Continue()
        {
            btnContinue.click();
            return new SelectFlight(localDriver);
        }








}

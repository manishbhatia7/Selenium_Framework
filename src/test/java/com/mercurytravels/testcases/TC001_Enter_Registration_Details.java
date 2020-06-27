package com.mercurytravels.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercurytravels.pageobjects.*;
import com.mercurytravels.utilities.XLUtils;

public class TC001_Enter_Registration_Details extends BaseClass {

    @Test(dataProvider="registrationData" )
    public void enter_Registration_Details(String fName,String lName,String phone,String email,String address,String city,String state,String pinCode,String country,String userName,String password) throws InterruptedException, IOException {
        driver.get(baseUrl);
        logger.info("Assertion starts for First Test Case");
        logger.info("Registration Details Will now be entered into registration details page");
        Registration reg=new Registration(driver);
        logger.info("First Name Entered");
        reg.setfirstName(fName);
        logger.info("Last Name Entered");
        reg.setlastName(lName);
        logger.info("Phone Entered");
        reg.setPhone(phone);
        logger.info("Email Entered");
        reg.setEmail(email);
        logger.info("Address Entered");
        reg.setAddress(address);
        logger.info("City Entered");
        reg.setCity(city);
        logger.info("State Entered");
        reg.setState(state);
        logger.info("Pincode Entered");
        reg.setPincode(pinCode);
        logger.info("Country selected in dropdown");
        reg.selectCountry(country);
        logger.info("Username Entered");
        reg.setUserName(userName);
        logger.info("Password Entered");
        reg.setPassword(password);
        logger.info("Confirmed Password Entered");
        reg.setConfirmedPassword(password);
        reg.submit_Registration_details();

        try
        {
            logger.info("Assertion for Registration");
            reg.assertion_for_Registration();
        }
        catch(AssertionError e)
        {
            logger.info("Assertion failed for Registration");
            captureScreen(driver,"enter_Registration_Details");
            throw e;
        }
        logger.info("Assertion Passed");
        SignOnPage signin=reg.click_On_Sign_in();

        }





        @DataProvider(name="registrationData")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercuryTravels\\testData\\Registration.xlsx";
        int rownum=XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path, "Sheet1",1);
        String registration[][]=new String[rownum][colcount];
        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                registration[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return registration;
    }

}

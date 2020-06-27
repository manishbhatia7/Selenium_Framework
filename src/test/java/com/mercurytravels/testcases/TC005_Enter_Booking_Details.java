package com.mercurytravels.testcases;
import com.mercurytravels.pageobjects.BookingReview;
import com.mercurytravels.pageobjects.PurchaseBookingTicket;
import com.mercurytravels.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC005_Enter_Booking_Details extends BaseClass {
    @Test(dataProvider = "BookingDetails")
    public void enter_Booking_Details(String fname,String lname,String meal,String cctype,String ccno,String address,String city,String state,String pcode,String country) throws IOException {
        PurchaseBookingTicket book=new PurchaseBookingTicket(driver);
        logger.info("**********************************************************");
        logger.info("Assertion starts for Fifth testcase");
        logger.info("");
        try
        {
            logger.info("Assertion starts to check incoming flight details");
            book.assert_in_Flight();
            logger.info("Assertion starts to check outgoing flight details");
            book.assert_out_Flight();
            logger.info("Assertion starts to check price");
            book.assert_Price();


        }
        catch(AssertionError e)
        {
            logger.info("Enter Booking details test failed");
            captureScreen(driver,"enter_Booking_Details");
            throw e;

        }

        logger.info("User enters first name");
        book.setFirstName(fname);
        logger.info("User enters last name");
        book.setLastName(lname);
        logger.info("User selects a meal");
        book.selectMeal(meal);
        logger.info("User selects a credit card type");
        book.selectCreditCardType(cctype);
        logger.info("User enters credit card no");
        book.setCreditCardNo(ccno);
        logger.info("User enters billing address");
        book.setBillingAddress(address);
        logger.info("User enters billing city");
        book.setBillingCity(city);
        logger.info("User enters billing state");
        book.setBillingState(state);
        logger.info("User enters billing pincode");
        book.setBillPincode(pcode);
        logger.info("User selects billing country");
        book.selectBillCountry(country);
        logger.info("User enters delivery address");
        book.setDeliveryAddress(address);
        logger.info("User enters delivery city");
        book.setDeliveryCity(city);
        logger.info("User enters delivery state");
        book.setDeliveryState(state);
        logger.info("User enters delivery city");
        book.setDeliveryCity(city);
        logger.info("User selects delivery country");
        book.selectDeliveryCountry(country);
        logger.info("User handles alert");
        book.handle_Alert();
        logger.info("User purchases a ticket by clicking on secure purchase button");
        BookingReview review=book.click_On_SecurePurchase();


    }

    @DataProvider(name="BookingDetails")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercuryTravels\\testData\\BookingDetails.xlsx";
        int rowNum= XLUtils.getRowCount(path,"Sheet1");
        int colCount=XLUtils.getCellCount(path,"Sheet1",1);
        String finder[][]=new String[rowNum][colCount];
        for(int i=1;i<=rowNum;i++)
        {
            for(int j=0;j<colCount;j++)
            {
                finder[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
            }
        }
        return finder;
    }
}

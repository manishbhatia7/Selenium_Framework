package com.mercurytravels.testcases;
import com.mercurytravels.pageobjects.BookingReview;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC006_Assert_Booking_Review_Details extends BaseClass {
    @Test
    public void assert_Booking_Details() throws IOException {
        BookingReview review=new BookingReview(driver);
        logger.info("**********************************************************");
        logger.info("Assertion starts for Sixth testcase");
        logger.info("");
        logger.info("Multiple assertions to check details are correct on booking review page");
        try
        {
            review.assert_Booking_Form();
        }
        catch(AssertionError e)
        {
            logger.info("Assert booking details test failed");
            captureScreen(driver,"assert_Booking_Details");
            throw e;

        }

        logger.info("User clicks on logout button");
        review.click_On_Logout();

    }



}

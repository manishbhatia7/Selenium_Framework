package com.mercurytravels.testcases;
import com.mercurytravels.pageobjects.PurchaseBookingTicket;
import com.mercurytravels.pageobjects.SelectFlight;
import com.mercurytravels.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC004_Select_To_From_Flights extends BaseClass {
    @Test(dataProvider ="selectFlights")
    public void select_Flights(String out,String in) throws InterruptedException, IOException {
        SelectFlight select=new SelectFlight(driver);
        logger.info("**********************************************************");
        logger.info("Assertion starts for Fourth testcase");
        logger.info("");
        logger.info("User selects flights");
        logger.info("User selects outgoing flight");
        select.select_Outgoing_Flight(out);
        logger.info("User selects incoming flight");
        select.select_Incoming_Flight(in);
        logger.info("Assertion starts for both outgoing and incoming flights");
        try
        {
            select.assert_Outgoing();
            select.assert_Incoming();
        }
        catch(AssertionError e)
        {
            logger.info("Flight selection Test Failed");
            captureScreen(driver,"select_Flights");
            throw e;
        }

        PurchaseBookingTicket booking=select.click_On_Continue();
        Thread.sleep(2000);


    }

    @DataProvider(name="selectFlights")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercuryTravels\\testData\\Airline_Details.xlsx";
        int rowNum= XLUtils.getRowCount(path,"Sheet1");
        int colCount=XLUtils.getCellCount(path,"Sheet1",1);
        String finder[][]=new String[rowNum][colCount];
        for(int i=1;i<=rowNum;i++)
        {
            for(int j=0;j<colCount;j++)
            {
                finder[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return finder;
    }

}

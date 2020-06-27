package com.mercurytravels.testcases;

import com.mercurytravels.pageobjects.FlightFinder;
import com.mercurytravels.pageobjects.SelectFlight;
import com.mercurytravels.utilities.XLUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC003_Select_To_From_City extends BaseClass {
    @Test(dataProvider="flightData" )
    public void enter_Pre_Flight_Search_Details(String rtype,String fcity,String ddate,String tcity,String adate) throws InterruptedException {
        FlightFinder ff=new FlightFinder(driver);
        logger.info("**********************************************************");
        logger.info("Assertion starts for Third testcase");
        logger.info("");
        logger.info("User entering flight details");
        logger.info("User selects trip type as One way");
        ff.selectTripType(rtype);
        logger.info("User selects from city");
        ff.selectFromCity(fcity);
        logger.info("User selects the departure date");
        ff.selectDepartDate(ddate);
        logger.info("User selects to city");
        ff.selectToCity(tcity);
        logger.info("User selects the arrival date");
        ff.selectArrivalDate(adate);
        logger.info("User clicks on continue button");
        SelectFlight select=ff.click_On_Continue();
        Thread.sleep(2000);


    }

    @DataProvider(name="flightData")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercuryTravels\\testData\\FlightFinder.xlsx";
        int rownum= XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path, "Sheet1",1);
        String finder[][]=new String[rownum][colcount];
        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                finder[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return finder;
    }

}

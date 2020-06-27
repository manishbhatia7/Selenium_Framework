package com.mercurytravels.testcases;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mercurytravels.pageobjects.*;
import com.mercurytravels.utilities.XLUtils;


public class TC002_Sign_In_Using_Registration_Details extends BaseClass {
    @Test(dataProvider="signInData" )
    public void enter_Signin_Credentials(String fName,String lName,String phone,String email,String address,String city,String state,String pinCode,String country,String userName,String password) throws InterruptedException, IOException {
     SignOnPage sign=new SignOnPage(driver);
     logger.info("**********************************************************");
     logger.info("Assertion starts for Second testcase");
     logger.info("");
     logger.info("Validating whether Sign on logo is available");
     try
     {
        sign.assert_Signon_Logo();
     }
        catch(AssertionError e)
     {
         logger.info("Sign in credentials test failed");
         captureScreen(driver,"enter_Signin_Credentials");
         throw e;
     }
     logger.info("User entering credentials into sign in page");
     logger.info("User entering username");
     sign.setuserName(userName);
     logger.info("User entering password");
     sign.setpassWord(password);
     logger.info("User clicks on Submit button");
     FlightFinder ff=sign.enter_User_Credentials();
     Thread.sleep(2000);
     }

    @DataProvider(name="signInData")
    public Object[][] getData() throws IOException
    {
        String path=System.getProperty("user.dir")+"\\src\\test\\java\\com\\mercuryTravels\\testData\\Registration.xlsx";
        int rownum=XLUtils.getRowCount(path,"Sheet1");
        int colcount=XLUtils.getCellCount(path, "Sheet1",1);
        String sign_in[][]=new String[rownum][colcount];
        for(int i=1;i<=rownum;i++)
        {
            for(int j=0;j<colcount;j++)
            {
                sign_in[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
            }
        }
        return sign_in;
    }

}

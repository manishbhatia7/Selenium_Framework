package com.mercurytravels.testcases;
import com.mercurytravels.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class BaseClass {
    ReadConfig readConfig=new ReadConfig();
    public String baseUrl= readConfig.getApplicationUrl();
    public static WebDriver driver;
    public static Logger logger;

    public void captureScreen(WebDriver driver, String tname) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
    @BeforeSuite
    @Parameters("browser")
        public void setUp(String br)
    {
        logger= Logger.getLogger("Mercury Tours Website");
        String log4jConfPath="log4j.properties";
        PropertyConfigurator.configure(log4jConfPath);

        if(br.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver",readConfig.getChromePath());
            driver=new ChromeDriver();
        }

        else if (br.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",readConfig.getFireFoxPath());
            driver=new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }

    @AfterSuite
    public void teardown()
    {
        driver.quit();
    }




}

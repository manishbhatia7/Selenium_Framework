package com.mercurytravels.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
Properties prop;
public ReadConfig()
{
    File src=new File("./Configuration/config.properties");
    try {

        FileInputStream fis=new FileInputStream(src);
        prop=new Properties();
        prop.load(fis);

    }catch(Exception e)
    {
        System.out.println("File not found with exception"+e.getMessage());
    }


}
public String getApplicationUrl()
{
    String url=prop.getProperty("BASEURL");
    return url;
}
public  String getChromePath()
{
    String chromepath=prop.getProperty("CHROMEPATH");
    return chromepath;
}
public String getFireFoxPath()
{
    String firefoxpath=prop.getProperty("FIREFOXPATH");
    return firefoxpath;
}

}

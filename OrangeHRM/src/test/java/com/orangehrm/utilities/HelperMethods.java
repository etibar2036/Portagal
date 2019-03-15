package com.orangehrm.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

//import utilities.Driver;

public class HelperMethods {

	public static String getScreenshot(String name) {

        String time = new SimpleDateFormat("_yyyy_MM_dd_hh:mm:ss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();

        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String target = System.getProperty("user.dir") + "/test-output/screenshots/" + name + time + ".png";

        File finalDestination = new File(target);

        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException io) {
        	
        }

        return target;
    }
	
}

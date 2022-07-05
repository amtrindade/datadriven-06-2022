package com.datadriven.core;

import static com.datadriven.core.DriverFactory.getDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

public abstract class BaseTest {

	@AfterMethod
	public void tearDown(ITestResult testName) throws IOException {
		
		File screen = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("target"+ File.separator + "screenshots" + File.separator +
				testName.getName()+"_"+ new Date() +".jpg"));
	}
	
	@AfterTest
	public void tearKill() {
		DriverFactory.killDriver();
	}
}

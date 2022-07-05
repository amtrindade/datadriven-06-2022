package com.datadriven.page;

import static com.datadriven.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePage {
	
	public String getTextH1() {
		WebElement labelH1 = getDriver().findElement(By.id("firstHeading"));
		return labelH1.getText();
	}

}

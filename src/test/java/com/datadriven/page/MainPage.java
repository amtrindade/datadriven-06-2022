package com.datadriven.page;

import static com.datadriven.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open() {
		getDriver().get("https://en.wikipedia.org/");
		return this;
	}
	
	public ArticlePage searchCountry(String country) {
		WebElement tfSearchInput = getDriver().findElement(By.id("searchInput"));
		tfSearchInput.sendKeys(country);
		
		WebElement btnSearch = getDriver().findElement(By.id("searchButton"));
		btnSearch.click();
		
		return new ArticlePage();
	}
}

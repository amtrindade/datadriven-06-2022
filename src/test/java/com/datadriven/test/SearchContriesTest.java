package com.datadriven.test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.datadriven.core.BaseTest;
import com.datadriven.core.SpreadsheetData;
import com.datadriven.page.ArticlePage;
import com.datadriven.page.MainPage;

public class SearchContriesTest extends BaseTest {
	private MainPage mainPage;
	private ArticlePage articlePage;
	
	@Test(dataProvider = "countriesExcel")
	public void testSearchCountriesExcel(String searchCountry, String expectedCountry) {
		mainPage = new MainPage();
		mainPage.open();
		articlePage = mainPage.searchCountry(searchCountry);
		
		assertEquals(articlePage.getTextH1(), expectedCountry);
	}
	
	@DataProvider(name = "countriesExcel")
	public Object[][] dataProviderExcel(){
		Object[][] testData = SpreadsheetData
				.readExcelData(
						"Paises", 
						"src/test/resources/paises.xls", 
						"Dados");
		return testData;
	}
	
	@Test(dataProvider = "countriesList")
	public void testSearchCountriesList(String searchCountry, String expectedCountry) {
		mainPage = new MainPage();
		mainPage.open();
		articlePage = mainPage.searchCountry(searchCountry);
		
		assertEquals(articlePage.getTextH1(), expectedCountry);
	}
	
	@DataProvider(name = "countriesList")
	public Object[][] dataProviderCountries() {
		return new Object[][] {
			{"India", "India" },
			{"Brazil", "Brasil" },
			{"Argentina", "Argentina"},
			{"Italy", "Italy"},
			{"Venezuela", "Venezuela"},
			{"United States", "United States"}
		};
	}

}

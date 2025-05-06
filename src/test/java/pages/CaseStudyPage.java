package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CaseStudyPage {
WebDriver driver;
	
	public CaseStudyPage(WebDriver driver) {
		this.driver = driver;
	}
	By headerCaseStudy = By.xpath("//h1[contains(text(),'Berbagi cerita dari kolaborasi HIGO')]");
	By titleKintaro = By.xpath("//div[normalize-space()='Kintaro Sushi']");
	By titleHomeCredit = By.xpath("//div[normalize-space()='Home Credit']");
	By h2Kintaro = By.xpath("//h2[normalize-space()='Kintaro Sushi']");
	By h2HomeCredit = By.xpath("//h2[normalize-space()='Home Credit']");

	public boolean isHeaderCaseStudyDisplayed() {
		return driver.findElement(headerCaseStudy).isDisplayed();
	}
	
	public void clickFilterByName(String filterName) {
		By filterLocator = By.xpath("//ul//li[text()='" + filterName + "']");
	    driver.findElement(filterLocator).click();
	}
	 
	public void clickClientHigoSpot() {
		driver.findElement(titleKintaro).click();
	}
	public void clickClientWifi() {
		driver.findElement(titleHomeCredit).click();
	}
	public int getFilteredResultsCount(String filterName) {
	    By filteredResultLocator;
	    
	    if (filterName.equalsIgnoreCase("All")) {
	        filteredResultLocator = By.xpath("//div[@class='mt-1 text-sm']");
	    } else {
	        filteredResultLocator = By.xpath("//div[@class='mt-1 text-sm' and text()='" + filterName + "']");
	    }

	    return driver.findElements(filteredResultLocator).size();
	}
	public boolean isFilteredResultDisplayed(String filterName) {
        return getFilteredResultsCount(filterName) > 0;
    }
	
	public boolean isHeaderClientIsDisplayed() {
		return driver.findElement(h2Kintaro).isDisplayed();
	}
	public boolean isHeaderClientWifiDisplayed() {
		return driver.findElement(h2Kintaro).isDisplayed();
	}
}

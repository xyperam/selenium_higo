package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DigitalReports {
	WebDriver driver;
	
	public DigitalReports(WebDriver driver) {
		this.driver = driver;
	}
	By DigitalHeaderText = By.xpath("//h1[normalize-space()='Digital Reports']");
	public boolean isDigitalHeaderDisplayed() {
		return driver.findElement(DigitalHeaderText).isDisplayed();
	}
}

package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DigitalReports {
	WebDriver driver;
	 WebDriverWait wait;
	public DigitalReports(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	By DigitalHeaderText = By.xpath("//h1[normalize-space()='Digital Reports']");
	public boolean isDigitalHeaderDisplayed() {
		return driver.findElement(DigitalHeaderText).isDisplayed();
		
	}
}

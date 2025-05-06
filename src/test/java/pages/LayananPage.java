package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LayananPage {
	WebDriver driver;
	
	public LayananPage(WebDriver driver) {
		this.driver = driver;
	}
	By titleWifiAdvertising = By.xpath("//h1[contains(text(), 'WiFi Advertising')]");
	By titleHigoSpot = By.xpath("//h1[contains(text(), 'HIGOspot')]");
	By titleIDigitalAgency = By.xpath("//h1[contains(text(), 'Integrated Digital Agency')]");
	
	
	public boolean isTitleDisplayed() {
		return driver.findElement(titleWifiAdvertising).isDisplayed();
	}
	public boolean isHeaderDigitalAgencyDisplayed() {
		return driver.findElement(titleIDigitalAgency).isDisplayed();
	}
	public boolean isHeaderHigoSpotDisplayed() {
		return driver.findElement(titleHigoSpot).isDisplayed();
	}

}


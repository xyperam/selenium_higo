package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	By headerText = By.xpath("//h1[contains(text(),'Solusi Menyeluruh Pemasaran Digital dengan WiFi & ')]");
	public boolean isHeaderDisplayed() {
		return driver.findElement(headerText).isDisplayed();
	}
}

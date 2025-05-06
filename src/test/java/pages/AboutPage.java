package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AboutPage {
	WebDriver driver;
	
	public AboutPage(WebDriver driver) {
		this.driver = driver;
	}
	By aboutHeaderText = By.xpath("//h1[normalize-space()='Tentang HIGO']");
	public boolean isAboutHeaderDisplayed() {
		return driver.findElement(aboutHeaderText).isDisplayed();
	}
}

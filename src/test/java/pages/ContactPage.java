package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	By ContactHeaderText = By.xpath("//h1[normalize-space()='Hubungi tim HIGO']");
	public boolean isContactHeaderDisplayed() {
		return driver.findElement(ContactHeaderText).isDisplayed();
	}
}

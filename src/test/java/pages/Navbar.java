package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class Navbar {
	WebDriver driver;
	
	public Navbar(WebDriver driver) {
		this.driver = driver;
	}
	
	By navAbout = By.cssSelector("a[href='/about-us']");
	By dropdownLabel = By.xpath("//label[@class='peer-checked:hidden']//span[contains(text(),'Layanan HIGO')]");
	By elWifiAdvertising = By.cssSelector("a[href='/wifi-advertising']");
	By elHigospot = By.cssSelector("a[href='/higospot']");
	By elDigitalAgency = By.cssSelector("a[href='/integrated-digital-agency']");
	By caseStudy = By.cssSelector("a[href='/case-study']");
	By DigitalReports = By.cssSelector("a[href='/digital-reports']");
	By contact = By.cssSelector("a[href='/contact-us']");
	public void clickNavAbout() {
		driver.findElement(navAbout).click();
	}
	public void clickCaseStudy() {
		driver.findElement(caseStudy).click();
	}
	
	public void hoverDropdownLayanan() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(dropdownLabel)).perform();
	}
	
	public void clickWifiAdvertising() {
		hoverDropdownLayanan();
		driver.findElement(elWifiAdvertising).click();
	}
	
	public void clickHigospot() {
		hoverDropdownLayanan();
		driver.findElement(elHigospot).click();
	}
	public void clickDigitalAgency() {
		hoverDropdownLayanan();
		driver.findElement(elDigitalAgency).click();
	}
	public void clickDigitalReports() {
		driver.findElement(DigitalReports).click();
	}
	public void clickContact() {
		driver.findElement(contact).click();
	}
}

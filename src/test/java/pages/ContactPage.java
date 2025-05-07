package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactPage {
	WebDriver driver;
	
	public ContactPage(WebDriver driver) {
		this.driver = driver;
	}
	By ContactHeaderText = By.xpath("//h1[normalize-space()='Hubungi tim HIGO']");
	By fieldName = By.xpath("//input[@placeholder='ex.Clara']");
	By fieldEmail = By.xpath("//input[@placeholder='clara@gmail.com']");
	By fieldPhoneNumber = By.xpath("//input[@placeholder='+628******']");
	By fieldCompany = By.xpath("//input[@placeholder='ex.HIGO']");
	By dropdownHigo = By.xpath("//input[@placeholder='ex.HIGO']");
	By fieldMessage = By.xpath("//textarea[@placeholder='Tulis pesan kamu']");
	By errName = By.xpath("//p[normalize-space()='Isi nama kamu']");
	By errEmail = By.xpath("//p[normalize-space()='Isi email kamu']");
	By errPhoneNumber = By.xpath("//p[normalize-space()='Isi dengan nomor telpon kamu']");
	By errCompany = By.xpath("//p[normalize-space()='Isi nama usaha kamu']");
	By errMessage = By.xpath("//p[normalize-space()='Isi dengan pesan kamu']");
	By buttonSubmit = By.xpath("//button[@type='submit']");
	By overlay = By.xpath("//button[@class='mt-1 self-start rounded-full bg-gray-200 p-1']//*[name()='svg']");
	public void clearForm() {
        driver.findElement(fieldName).clear();
        driver.findElement(fieldEmail).clear();
        driver.findElement(fieldCompany).clear();
        driver.findElement(fieldPhoneNumber).clear();
        driver.findElement(fieldMessage).clear();
	}
	public boolean isContactHeaderDisplayed() {
		return driver.findElement(ContactHeaderText).isDisplayed();
	}
	public boolean isErrNameDisplayed() {
		return driver.findElement(errName).isDisplayed();
	}
	public boolean isErrPhoneNumberDisplayed() {
		return driver.findElement(errPhoneNumber).isDisplayed();
	}
	public boolean isErrEmailDisplayed() {
		return driver.findElement(errEmail).isDisplayed();
	}
	public boolean isErrCompanyDisplayed() {
		return driver.findElement(errCompany).isDisplayed();
	}

	public void inputName(String name) {
		driver.findElement(fieldName).sendKeys(name);
	}
	public void inputEmail(String email) {
		driver.findElement(fieldEmail).sendKeys(email);
	}
	public void inputPhoneNumber(String pNumber) {
		driver.findElement(fieldPhoneNumber).sendKeys(pNumber);
	}
	public void inputLayananHigo() {
		driver.findElement(dropdownHigo).click();
	}
	public void inputMessage(String message) {
		driver.findElement(fieldMessage).sendKeys(message);
	}
	public void inputCompany(String company) {
		driver.findElement(fieldCompany).sendKeys(company);
	}
	public void clickSubmit() {
		driver.findElement(buttonSubmit).click();
	}
	public void clickOverlay() {
		driver.findElement(overlay).click();
	}
	
}

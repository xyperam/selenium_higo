package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class BlogPage {
	WebDriver driver;
	
	public BlogPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By fieldName = By.xpath("//input[@placeholder='Tulis Nama Kamu']");
	By fieldComment = By.xpath("//textarea[@placeholder='Tulis Komentar Kamu']");
	By buttonSubmit = By.xpath("//button[normalize-space()='Kirim']");
	By timeStampElement = By.cssSelector("time.text-gray-400");
	By errName = By.xpath("//p[normalize-space()='Isi nama kamu']");
	By errComment = By.xpath("//p[normalize-space()='Isi komen kamu']");
	
	
	public void openArticleDirectly() {
	    driver.get("https://blog.higo.id/5-rekomendasi-cafe-nyaman-wfc-di-jakarta-selatan");
	    Assert.assertTrue(driver.getTitle().contains("Cafe Nyaman"), "Artikel tidak berhasil dibuka.");
	}
	public boolean isErrNameDisplayed() {
		return driver.findElement(errName).isDisplayed();
	}
	public boolean isErrCommentDisplayed() {
		return driver.findElement(errComment).isDisplayed();
	}
	
	public void inputName(String name) {
		driver.findElement(fieldName).sendKeys(name);
	}
	public void inputComment(String comment) {
		driver.findElement(fieldComment).sendKeys(comment);
	}
	public void clickSubmit() {
		driver.findElement(buttonSubmit).click();
	}
	public boolean isSubmitButtonDisabled() {
	  WebElement submitButton = driver.findElement(buttonSubmit);
	        // Cek apakah tombol memiliki atribut disabled
	        return submitButton.getAttribute("disabled") != null;
	 }
	
	
}

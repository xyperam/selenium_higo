package tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.AboutPage;
import pages.BlogPage;
import pages.CaseStudyPage;
import pages.ContactPage;
import pages.DigitalReports;
import pages.HomePage;
import pages.LayananPage;
import pages.Navbar;

public class HigoCompanyProfileTest {
	WebDriver driver;
	HomePage homePage;
	AboutPage aboutPage;
	Navbar	navbar;
	LayananPage layananPage;
	CaseStudyPage caseStudyPage;
	DigitalReports digitalReports;
	ContactPage contactPage;
	BlogPage blogPage;
	@BeforeClass (alwaysRun = true)
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		homePage = new HomePage(driver);
		aboutPage = new AboutPage(driver);
		navbar = new Navbar(driver);
		layananPage = new LayananPage(driver);
		caseStudyPage = new CaseStudyPage(driver);
		digitalReports = new DigitalReports(driver);
		contactPage = new ContactPage(driver);
		blogPage = new BlogPage(driver);
	}
	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() {
		driver.get("https://www.higo.id/");
	}
	
	
	@Test(priority = 1, description= "TC_001: As a user i can go to Home page ")
	public void verifyHeaderHomePage() {
		
		Assert.assertTrue(homePage.isHeaderDisplayed(),"Header tidak tampil");
	}
	
	@Test (priority = 2,description= "TC_002: As a user i can go to About page ")
	public void verifyAboutPage() {
		navbar.clickNavAbout();
		Assert.assertTrue(aboutPage.isAboutHeaderDisplayed(),"Header About page tidak tampil");
	}
	@Test(priority = 3,description= "TC_003: As a user i can go to Wifi Advertising page")
	public void verifyWifiAdvertisingPage() {
		navbar.clickWifiAdvertising();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(layananPage.isTitleDisplayed(),"Title Wifi Advertising tidak tampil");
	}
	
	@Test(priority = 4,description= "TC_004: As a user i can go to HIGOspot page")
	public void verifyHigoSpotPage() throws InterruptedException {
		navbar.clickHigospot();
		Thread.sleep(1000);
		System.out.println("berhasil navigasi");
		Thread.sleep(1000);
		Assert.assertTrue(layananPage.isHeaderHigoSpotDisplayed(),"Header HigoSpot tidak tampil");
	}
	@Test(priority = 5,description= "TC_005: As a user i can go to Integrated Digital Agency page")
	public void verifyIntegratedDigitalAgency() throws InterruptedException {
		navbar.clickDigitalAgency();
		Thread.sleep(1000);
		System.out.println("berhasil navigasi");
		Thread.sleep(1000);
		Assert.assertTrue(layananPage.isHeaderDigitalAgencyDisplayed(),"Header Integrated Digital Agency tidak tampil");
	}
	@Test(priority = 6,description= "TC_006: As a user i can go to Case Study Page")
	public void verifyCaseStudy() {
		navbar.clickCaseStudy();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(caseStudyPage.isHeaderCaseStudyDisplayed(),"Header Case Study tidak tampil");
	}
	@Test(priority = 7,description= "TC_007: As a user i can use filter HigoSpot")
	public void verifyFilterHigospot() throws InterruptedException {
		String filterName = "HIGOspot";
		verifyCaseStudy();
		Thread.sleep(1000);
		caseStudyPage.clickFilterByName(filterName);
		Thread.sleep(1000);
		 Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(priority = 8,description= "TC_008: As a user i can use filter Wifi Advertising")
	public void verifyFilterWifiAdvertising() throws InterruptedException {
		String filterName = "WiFi Advertising";
		verifyCaseStudy();
		Thread.sleep(3000);
		caseStudyPage.clickFilterByName(filterName);
		Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(priority = 9,description= "TC_009: As a user i can use filter all")
	public void verifyFilterAll() throws InterruptedException {
		String filterName = "All";
		verifyCaseStudy();
		Thread.sleep(3000);
		caseStudyPage.clickFilterByName(filterName);
		Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(priority = 10,description= "TC_010: As a user i can go to client HigoSpot page")
	public void verifyNavigateClientHigospot() throws InterruptedException {
		verifyFilterHigospot();
		caseStudyPage.clickClientHigoSpot();
		Thread.sleep(1000);
		Assert.assertTrue(caseStudyPage.isHeaderClientIsDisplayed(),"Navigasi detail client gagal");
		
	}
	@Test(priority = 11,description= "TC_011: As a user i can go to client Wifi page")
	public void verifyNavigateClientWifi() throws InterruptedException {
		verifyFilterWifiAdvertising();
		Thread.sleep(1000);
		caseStudyPage.clickClientWifi();
		Thread.sleep(1000);
		Assert.assertTrue(caseStudyPage.isHeaderClientWifiDisplayed(),"Navigasi detail client gagal");
	}
	@Test(priority = 12,description= "TC_012: As a user i can go to Digital Reports page")
	public void verifyNavigateToDigitalReportsPage() throws InterruptedException {
		navbar.clickDigitalReports();
		Thread.sleep(1000);
		Assert.assertTrue(digitalReports.isDigitalHeaderDisplayed(),"Navigasi digita gagal");
	}
	
	@Test(priority = 13,description= "TC_013: As a user i can go to Contact page")
	public void verifyNavigateToContactPage() throws InterruptedException {
		navbar.clickContact();
		contactPage.clickOverlay();
		Assert.assertTrue(contactPage.isContactHeaderDisplayed(),"Navigasi contact gagal");
	}
	
	@Test(priority = 14,description = "TC_014: As user i can submit form")
	public void submitForm() throws InterruptedException {
		String name = "test";
		String email = "test123@gmail.com";
		String pNumber = "+62895403707800";
		String message = "test";
		String company = "test";
		verifyNavigateToContactPage();
		contactPage.clearForm();
		contactPage.inputName(name);
		contactPage.inputEmail(email);
		contactPage.inputPhoneNumber(pNumber);
		contactPage.inputLayananHigo();
		contactPage.inputMessage(message);
		contactPage.inputCompany(company);
		contactPage.clickSubmit();
	}
	@Test(priority = 15,description = "TC_015: As user i cannot submit with empty full name field")
	public void invalidNameForm() throws InterruptedException {
		String name = "";
		String email = "test123@gmail.com";
		String pNumber = "+62895403707800";
		String message = "test";
		String company = "test";
		verifyNavigateToContactPage();
		contactPage.clearForm();
		contactPage.inputName(name);
		contactPage.inputEmail(email);
		contactPage.inputPhoneNumber(pNumber);
		contactPage.inputLayananHigo();
		contactPage.inputMessage(message);
		contactPage.inputCompany(company);
		contactPage.clickSubmit();
		Assert.assertTrue(contactPage.isErrNameDisplayed(),"Invalid error name doesn't display");
	}
	@Test(priority = 16,description = "TC_016: As user i cannot submit with empty phone number field")
	public void invalidPhoneNumberForm() throws InterruptedException {
		String name = "test";
		String email = "test123@gmail.com";
		String pNumber = "";
		String message = "test";
		String company = "test";
		verifyNavigateToContactPage();
		contactPage.clearForm();
		contactPage.inputName(name);
		contactPage.inputEmail(email);
		contactPage.inputPhoneNumber(pNumber);
		contactPage.inputLayananHigo();
		contactPage.inputMessage(message);
		contactPage.inputCompany(company);
		contactPage.clickSubmit();
		Assert.assertTrue(contactPage.isErrPhoneNumberDisplayed(),"Invalid error phone number doesn't display");
	}
	@Test(priority = 17,description = "TC_017: As user i cannot submit with empty email field")
	public void invalidEmailForm() throws InterruptedException {
		String name = "test";
		String email = "";
		String pNumber = "+62895403707800";
		String message = "test";
		String company = "test";
		verifyNavigateToContactPage();
		contactPage.clearForm();
		contactPage.inputName(name);
		contactPage.inputEmail(email);
		contactPage.inputPhoneNumber(pNumber);
		contactPage.inputLayananHigo();
		contactPage.inputMessage(message);
		contactPage.inputCompany(company);
		contactPage.clickSubmit();
		Assert.assertTrue(contactPage.isErrEmailDisplayed(),"Invalid error email doesn't display");
	}
	@Test(priority = 18,description = "TC_018: As user i cannot submit with empty company/brand/event")
	public void invalidCompanyForm() throws InterruptedException {
		String name = "test";
		String email = "test123@gmail.com";
		String pNumber = "+62895403707800";
		String message = "test";
		String company = "";
		verifyNavigateToContactPage();
		contactPage.clearForm();
		contactPage.inputName(name);
		contactPage.inputEmail(email);
		contactPage.inputPhoneNumber(pNumber);
		contactPage.inputLayananHigo();
		contactPage.inputMessage(message);
		contactPage.inputCompany(company);
		contactPage.clickSubmit();
		Assert.assertTrue(contactPage.isErrCompanyDisplayed(),"Invalid error company doesn't display");
	}
	
	@Test(priority = 19,description = "TC_019: As user i can go to Higo Blog")
	public void verifyNavigateToBlog() {
		navbar.clickNavBlog();
	}
	@Test(priority = 20,description = "TC_020: As user i can add comment")
	public void addComment() {
		String name = "test";
		String comment ="testing";
		navbar.clickNavBlog();
		blogPage.openArticleDirectly();
		blogPage.inputComment(name);
		blogPage.inputComment(comment);
		blogPage.clickSubmit();	
	}

	@Test(priority = 21,description = "TC_021: As user i cannot add comment with empty name and comment")
	public void verifyBlankForm() {
		String name = "";
		String comment ="";
		navbar.clickNavBlog();
		blogPage.openArticleDirectly();
		blogPage.inputComment(name);
		blogPage.inputComment(comment);
		blogPage.clickSubmit();
		Assert.assertTrue(blogPage.isSubmitButtonDisabled(), "Tombol kirim tidak dalam keadaan disabled meskipun form kosong.");
	}
	
	
	@AfterMethod
	public void takeScreenshotOnFailure(ITestResult result) {
	    if (ITestResult.FAILURE == result.getStatus()) {
	        captureScreenshot(result.getName());
	    }
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

public void captureScreenshot(String methodName) {
	try {
		  if (driver == null) {
		        Reporter.log("Gagal mengambil screenshot: driver tidak tersedia", true);
		        return;
		    }
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
		String filepath = "test-output/screenshots/"+ methodName +"_"+timestamp+".png";
		
		FileUtils.copyFile(source,new File(filepath));
		Reporter.log("Screenshoot disimpan: "+filepath,true);
		
	}catch(IOException e){
		Reporter.log("Gagal mengambil screenshot: "+ e.getMessage(),true);
	}
}
}

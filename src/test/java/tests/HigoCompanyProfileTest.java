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
	}
	@BeforeMethod(alwaysRun = true)
	public void navigateToHomePage() {
		driver.get("https://www.higo.id/");
	}
	
	
	@Test(description= "TC_001: As a user i can go to Home page ")
	public void verifyHeaderHomePage() {
		
		Assert.assertTrue(homePage.isHeaderDisplayed(),"Header tidak tampil");
	}
	
	@Test (description= "TC_002: As a user i can go to About page ")
	public void verifyAboutPage() {
		navbar.clickNavAbout();
		Assert.assertTrue(aboutPage.isAboutHeaderDisplayed(),"Header About page tidak tampil");
	}
	@Test(description= "TC_003: As a user i can go to Wifi Advertising page")
	public void verifyWifiAdvertisingPage() {
		navbar.clickWifiAdvertising();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(layananPage.isTitleDisplayed(),"Title Wifi Advertising tidak tampil");
	}
	
	@Test(description= "TC_004: As a user i can go to HIGOspot page")
	public void verifyHigoSpotPage() {
		navbar.clickHigospot();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(layananPage.isHeaderHigoSpotDisplayed(),"Header HigoSpot tidak tampil");
	}
	@Test(description= "TC_005: As a user i can go to Integrated Digital Agency page")
	public void verifyIntegratedDigitalAgency() {
		navbar.clickDigitalAgency();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(layananPage.isHeaderDigitalAgencyDisplayed(),"Header Integrated Digital Agency tidak tampil");
	}
	@Test(description= "TC_006: As a user i can go to Case Study Page")
	public void verifyCaseStudy() {
		navbar.clickCaseStudy();
		System.out.println("berhasil navigasi");
		Assert.assertTrue(caseStudyPage.isHeaderCaseStudyDisplayed(),"Header Case Study tidak tampil");
	}
	@Test(description= "TC_007: As a user i can use filter HigoSpot")
	public void verifyFilterHigospot() throws InterruptedException {
		String filterName = "HIGOspot";
		verifyCaseStudy();
		Thread.sleep(3000);
		caseStudyPage.clickFilterByName(filterName);
		 Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(description= "TC_008: As a user i can use filter Wifi Advertising")
	public void verifyFilterWifiAdvertising() throws InterruptedException {
		String filterName = "WiFi Advertising";
		verifyCaseStudy();
		Thread.sleep(3000);
		caseStudyPage.clickFilterByName(filterName);
		Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(description= "TC_009: As a user i can use filter all")
	public void verifyFilterAll() throws InterruptedException {
		String filterName = "All";
		verifyCaseStudy();
		Thread.sleep(3000);
		caseStudyPage.clickFilterByName(filterName);
		Assert.assertTrue(caseStudyPage.isFilteredResultDisplayed(filterName), "Hasil filter tidak tampil untuk: " + filterName);
		
	}
	@Test(description= "TC_010: As a user i can go to client HigoSpot page")
	public void verifyNavigateClientHigospot() throws InterruptedException {
		verifyFilterHigospot();
		caseStudyPage.clickClientHigoSpot();
		Assert.assertTrue(caseStudyPage.isHeaderClientIsDisplayed(),"Navigasi detail client gagal");
		
	}
	@Test(description= "TC_011: As a user i can go to client HigoSpot page")
	public void verifyNavigateClientWifi() throws InterruptedException {
		verifyFilterWifiAdvertising();
		caseStudyPage.clickClientWifi();
		Assert.assertTrue(caseStudyPage.isHeaderClientWifiDisplayed(),"Navigasi detail client gagal");
	}
	@Test(description= "TC_012: As a user i can go to Digital Reports page")
	public void verifyNavigateToDigitalReportsPage() throws InterruptedException {
		navbar.clickDigitalReports();
		Assert.assertTrue(digitalReports.isDigitalHeaderDisplayed(),"Navigasi digita gagal");
	}
	
	@Test(description= "TC_013: As a user i can go to Contact page")
	public void verifyNavigateToContactPage() throws InterruptedException {
		navbar.clickContact();
		Assert.assertTrue(contactPage.isContactHeaderDisplayed(),"Navigasi contact gagal");
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

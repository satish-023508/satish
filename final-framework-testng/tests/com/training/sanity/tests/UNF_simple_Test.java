package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
import com.training.pom.UNF_simple_POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class UNF_simple_Test {
	
	private static Properties properties;
	private WebDriver driver;
	private String baseUrl;
	private UNF_simple_POM unf_simple_POM;
	private ScreenShot screenShot;
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		unf_simple_POM = new UNF_simple_POM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
  @Test
	public void UNF013Test() {
		unf_simple_POM.sendUserName("admin");
		unf_simple_POM.sendPassword("admin@123");
		unf_simple_POM.clickLoginBtn(); 
		unf_simple_POM.Verifyingdashboardtext();
		screenShot.captureScreenShot("screenshots/UNF013_dashboard");
		unf_simple_POM.clickProducts();
		screenShot.captureScreenShot("screenshots/UNF013_products");
		unf_simple_POM.enterproductname("Blazer Girls");
		unf_simple_POM.clickfilterbtn(); 
		unf_simple_POM.countitems(); 
		screenShot.captureScreenShot("screenshots/UNF013_filter_results");
	} 
	
	   @Test
	public void UNF014Test() throws InterruptedException {
		unf_simple_POM.sendUserName("admin");
		unf_simple_POM.sendPassword("admin@123");
		unf_simple_POM.clickLoginBtn(); 
		unf_simple_POM.Verifyingdashboardtext();
		screenShot.captureScreenShot("screenshots/UNF014_dashboard");
		unf_simple_POM.clickProducts();
		unf_simple_POM.enterproductname("Blazer");
		screenShot.captureScreenShot("screenshots/UNF014_products");
		unf_simple_POM.clickfilterbtn(); 
		screenShot.captureScreenShot("screenshots/UNF014_filter_results");
		unf_simple_POM.deleteProduct();
		screenShot.captureScreenShot("screenshots/UNF014_after_del_results");
	} 
	
	@Test
	public void UNF015Test() {
		unf_simple_POM.sendUserName("admin");
		unf_simple_POM.sendPassword("admin@123");
		unf_simple_POM.clickLoginBtn(); 
		unf_simple_POM.clickorders();
		unf_simple_POM.startdate("2019-10-10");
		unf_simple_POM.enddate("2019-11-11");
		unf_simple_POM.filterbtn();
		unf_simple_POM.itemscount();
		screenShot.captureScreenShot("screenshots/UNF015_filter_results1");
		unf_simple_POM.selectgroup();
		unf_simple_POM.selectorderstatus();
		unf_simple_POM.filterbtn();
		unf_simple_POM.itemscount();
		screenShot.captureScreenShot("screenshots/UNF015_filter_results2");
	}

}


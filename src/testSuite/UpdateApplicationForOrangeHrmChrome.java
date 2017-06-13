package testSuite;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.management.modelmbean.RequiredModelMBean;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.testng.TestException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import dataSrc.OrangeHrm_MyDetails_DataProvider;
import pageSrc.OrangeHrmLoginPage;
import pageSrc.OrangeHrmUpdatePage;;



public class UpdateApplicationForOrangeHrmChrome {

	private WebDriver driver = null;
	OrangeHrmLoginPage obj_Login_Page;
	OrangeHrmUpdatePage obj_MyDetails_Page;
	

	@BeforeTest
	public void setup() throws MalformedURLException, InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sl060497\\Downloads\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", "C:\\Users\\sl060497\\Downloads\\geckodriver.exe");
		Thread.sleep(20000);
		String app_URL = "http://opensource.demo.orangehrmlive.com/index.php/auth/login";
		//String hubURL = "http://10.220.220.95:4444/wd/hub";-chitra
		//System.setProperty("webdriver.ie.driver","D:\\JDK, Eclipse & Selenium exe\\IEDriverServer_Win32_2.46.0\\IEDriverServer.exe");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setBrowserName("Chrome");
		capability.setPlatform(Platform.WINDOWS);
		capability.setVersion("11");
//		capability.setCapability("applicationCacheEnabled", true);
	//	driver = new RemoteWebDriver(new URL(hubURL),capability);	-chitra	
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(app_URL);	


	}

	@Test(testName = "IEBrowserTest", dataProvider = "InternetExplorer",dataProviderClass = OrangeHrm_MyDetails_DataProvider.class)
	public void OrangeHrmUpdatePage(String p_EmpMiddleName,String p_OtherID,String p_LicExpDate)throws InterruptedException {
		obj_Login_Page = new OrangeHrmLoginPage(driver);
		obj_Login_Page.login("Chitra", "Chitra");	
		
		/*obj_Login_Page = new CitizenPortal_LoginPage(driver);
		obj_Login_Page.login("testuser9@onetestsmtp.co.uk", "Password!23");*/
		
		

	}
	
	@AfterTest
	public void closeBrowser(){
		driver.close();
		driver.quit();
	}
}

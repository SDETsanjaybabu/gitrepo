package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver sdriver;
	public WebDriver driver;
	public DatabaseUtility dLib=new DatabaseUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriverUtility wLib=new WebDriverUtility();
	
	@BeforeSuite(groups= {"smokeTest","regressionTest"})
	public void dbConfig()
	{
		dLib.connectToDB();
	}
	//@Parameters("BROWSER")
	@BeforeClass
	public void launchBrowser() throws Throwable
	{
		String BROWSER = fLib.getPropertKeyValue("browser");
		//String BROWSER = System.getProperty("Browser");
		String URL = fLib.getPropertKeyValue("url");
		//String URL = System.getProperty("Url");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else {
			driver=new ChromeDriver();
		}
		sdriver=driver;
		wLib.waitForPageToLoad(driver);
		sdriver.get(URL);
	}
	@BeforeMethod(groups= {"smokeTest","regressionTest"})
	public void loginToApp() throws Throwable
	{
		String USERNAME = fLib.getPropertKeyValue("username");
		String PASSWORD = fLib.getPropertKeyValue("password");
		
		LoginPage lpage=new LoginPage(driver);
		lpage.loginToAppln(USERNAME, PASSWORD);
	}
	
	@AfterMethod(groups= {"smokeTest","regressionTest"})
	public void logoutFromApp()
	{
		HomePage hpage=new HomePage(driver);
		hpage.logout(driver);
	}
	@AfterClass(groups= {"smokeTest","regressionTest"})
	public void closeTheBrowser()
	{
		driver.quit();
	}
	@AfterSuite(groups= {"smokeTest","regressionTest"})
	public void closeDBconfig()
	{
		dLib.closeDB();
	}
}

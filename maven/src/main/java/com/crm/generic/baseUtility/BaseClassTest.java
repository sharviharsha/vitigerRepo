package com.crm.generic.baseUtility;

import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.comcast.crm.generic.databaseutility.DataBaseUtility;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webdriverutility.JavaUtility;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClassTest
{
	public WebDriver driver = null;
	public static WebDriver sdriver = null;
	public ExcelUtility eLib=new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public DataBaseUtility dbLib = new DataBaseUtility();
	public FileUtility fLib = new FileUtility();
	

	@BeforeSuite(groups = {"smokeTest", "regressionTest"})
	public void createConfigBs() {
		System.out.println("======connect DB , Report config=======");
		dbLib.getDbconnection();
		
		
	}
   @Parameters("BROWSER")
	@BeforeClass(groups = {"smokeTest", "regressionTest"})
	public void createConfigBC(String browser) throws Throwable {
		System.out.println("==Launch the Browser== ");
		//String BROWSER =fLib.getDataFromPropertiesFile("browser");
		String BROWSER=browser; 
		//String BROWSER=System.getProperty("browser",fLib.getDataFromPropertiesFile("browser"));
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
//		} 
//		else if (BROWSER.equals("opera")) {
//			driver = new OperaDriver();
		}else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
//		UtilityClassObject.setDriver(driver);
	}

	@BeforeMethod(groups = {"smokeTest", "regressionTest"})
	public void createConfigBM() throws Throwable {
		System.out.println("=Login=");
		//String URL = fLib.getDataFromPropertiesFile("url");
		//String USERNAME = fLib.getDataFromPropertiesFile("username");
		//String PASSWORD = fLib.getDataFromPropertiesFile("password");
		String URL = System.getProperty("url" , fLib.getDataFromPropertiesFile("url"));
		String USERNAME = System.getProperty("username" ,  fLib.getDataFromPropertiesFile("username"));
		String PASSWORD = System.getProperty("password" , fLib.getDataFromPropertiesFile("password"));
		LoginPage lp=new LoginPage(driver);
		lp.loginToapp(URL, USERNAME, PASSWORD);
	}

	@AfterMethod(groups = {"smokeTest", "regressionTest"})
	public void createConfigAM() {
		System.out.println("=Logout=");
		HomePage hm=new HomePage(driver);
		hm.logout();
	}

	@AfterClass(groups = {"smokeTest", "regressionTest"})
	public void createConfigAC() {
		System.out.println("==Close the Browser==");
		driver.quit();
	}

	@AfterSuite(groups = {"smokeTest", "regressionTest"})
	public void createConfigAS() throws SQLException {
		System.out.println("======Close DB , Report Backup=======");
		dbLib.closeDbconnection();
		
	}
}

package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


public class TestBase {
	
	public static Properties prop;
	public static WebDriver driver;
	
	ExtentTest extentTest;
	ExtentReports reports;
	ExtentHtmlReporter htmlReport;
	
	public TestBase()
	{
		prop= new Properties();
		try
		{
			FileInputStream fin = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//config//config.properties");
			prop.load(fin);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialize()
	{
		String browser = prop.getProperty("browser");
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\ProgramData\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	public static void Close()
	{
		driver.quit();
	}
	
	public void setupExtent() {
		reports = new ExtentReports();
		htmlReport = new ExtentHtmlReporter("C:\\Users\\ej758824\\Selenium\\Webdrivers\\Reports\\extentReport.html");
		reports.attachReporter(htmlReport);
		htmlReport.setAppendExisting(true);
	}
	
}

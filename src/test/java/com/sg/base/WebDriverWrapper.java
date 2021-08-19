package com.sg.base;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import com.sg.pages.DashboardPage;
import com.sg.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverWrapper {
	public static WebDriver driver;
	public static Scenario scenario;

	@Before
	public void setup(Scenario sc) {
		scenario = sc;
	}	

	public static void launchBrowser(String browser) {

		if (browser.equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		} else if (browser.equalsIgnoreCase("ff")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.openemr.io/b/openemr");
		
		initializePageClass();
	}
	
	
	public static void initializePageClass()
	{
		PageFactory.initElements(driver, LoginPage.class);
//		PageFactory.initElements(driver, DashboardPage.class);
	}

	@After
	public void tearDown(Scenario sc) throws IOException {
		sc.log(sc.getName() + " " + sc.getStatus() + " " + new Date().toString());
		if (sc.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
//			File file= ts.getScreenshotAs(OutputType.FILE);
//			FileUtils.copyFile(file, new File("error.png"));

			byte[] bytes = ts.getScreenshotAs(OutputType.BYTES);
			sc.attach(bytes, "image/png", "sc_" + new Date().toString());

		}

		System.out.println(sc.getName());
		System.out.println(sc.getStatus());

		WebDriverWrapper.driver.quit();
	}

}
